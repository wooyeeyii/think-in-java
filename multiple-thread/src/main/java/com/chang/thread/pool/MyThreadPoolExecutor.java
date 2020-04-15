package com.chang.thread.pool;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    volatile int runState;
    static final int RUNNING = 0;
    static final int SHUTDOWN = 1;
    static final int STOP = 2;
    static final int TERMINATED = 3;


    private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
    private final ReentrantLock mainLock = new ReentrantLock();   //线程池的主要状态锁，对线程池状态（比如线程池大小
    //、runState等）的改变都要使用这个锁
    private final HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集

    private volatile long keepAliveTime;    //线程存活时间
    private volatile boolean allowCoreThreadTimeOut;   //是否允许为核心线程设置存活时间
    private volatile int corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
    private volatile int maximumPoolSize;   //线程池最大能容忍的线程数

    private volatile int poolSize;       //线程池中当前的线程数

    private volatile RejectedExecutionHandler handler; //任务拒绝策略

    private volatile ThreadFactory threadFactory;   //线程工厂，用来创建线程

    private int largestPoolSize;   //用来记录线程池中曾经出现过的最大线程数

    private long completedTaskCount;   //用来记录已经执行完毕的任务个数

    public MyThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                RejectedExecutionHandler handler) {
        if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

    public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
            //此时的环境: 线程数量>=corePollSize 或者 (线程数量不多但开新线程失败)
            if (runState == RUNNING && workQueue.offer(command)) {
                //此时环境: 当前线程池处于RUNNING状态且将任务放入任务缓存队列成功
                if (runState != RUNNING || poolSize == 0) {
                    //为了防止在将此任务添加进任务缓存队列的同时其他线程突然调用shutdown或者shutdownNow方法关闭了线程池的一种应急措施
                    //ensureQueuedTaskHandled(command);
                }
            } else if (!addIfUnderMaximumPoolSize(command)) {    //线程池状态判断呢？？？
                reject(command); // is shutdown or saturated
            }
        }
    }

    /**
     * 线程数量小于核心池大小，且线程池正常工作，则创建线程执行新任务
     *
     * @param firstTask
     * @return
     */
    private boolean addIfUnderCorePoolSize(Runnable firstTask) {
        Thread t = null;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            if (poolSize < corePoolSize && runState == RUNNING)
                //再次判断的原因：前面的判断过程中并没有加锁，因此可能在execute方法判断的时候poolSize小于corePoolSize，
                //而判断完之后，在其他线程中又向线程池提交了任务，就可能导致poolSize不小于corePoolSize了，所以需要在这个地方继续判断
                t = addThread(firstTask);
        } finally {
            mainLock.unlock();
        }
        if (t == null)
            return false;
        t.start();
        return true;
    }

    /**
     * 当线程数量大于corePoolSize但小于最大数量时 .........
     *
     * @param firstTask
     * @return
     */
    private boolean addIfUnderMaximumPoolSize(Runnable firstTask) {
        Thread t = null;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            if (poolSize < maximumPoolSize && runState == RUNNING)
                t = addThread(firstTask);
        } finally {
            mainLock.unlock();
        }
        if (t == null)
            return false;
        t.start();
        return true;
    }

    void reject(Runnable command) {
        //handler.rejectedExecution(command, this);
    }

    private Thread addThread(Runnable firstTask) {
        Worker w = new Worker(firstTask);
        Thread t = threadFactory.newThread(w);  //创建一个线程，执行任务
        if (t != null) {
            w.thread = t;            //将创建的线程的引用赋值为w的成员变量
            workers.add(w);
            int nt = ++poolSize;     //当前线程数加1
            if (nt > largestPoolSize)
                largestPoolSize = nt;
        }
        return t;
    }

    Runnable getTask() {
        for (; ; ) {
            try {
                int state = runState;
                if (state > SHUTDOWN)
                    return null;
                Runnable r;
                if (state == SHUTDOWN)  // Help drain queue
                    r = workQueue.poll();
                else if (poolSize > corePoolSize || allowCoreThreadTimeOut) //如果线程数大于核心池大小或者允许为核心池线程设置空闲时间，
                    //则通过poll取任务，若等待一定的时间取不到任务，则返回null
                    r = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
                else
                    r = workQueue.take();
                if (r != null)
                    return r;
                if (workerCanExit()) {    //如果没取到任务，即r为null，则判断当前的worker是否可以退出
                    if (runState >= SHUTDOWN) // Wake up others
                        interruptIdleWorkers();   //中断处于空闲状态的worker
                    return null;
                }
                // Else retry
            } catch (InterruptedException ie) {
                // On interruption, re-check runState
            }
        }
    }

    private boolean workerCanExit() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        boolean canExit;
        //如果runState大于等于STOP，或者任务缓存队列为空了
        //或者  允许为核心池线程设置空闲存活时间并且线程池中的线程数目大于1
        try {
            canExit = runState >= STOP ||
                    workQueue.isEmpty() ||
                    (allowCoreThreadTimeOut &&
                            poolSize > Math.max(1, corePoolSize));
        } finally {
            mainLock.unlock();
        }
        return canExit;
    }

    void interruptIdleWorkers() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            for (Worker w : workers)  //实际上调用的是worker的interruptIfIdle()方法
                w.interruptIfIdle();
        } finally {
            mainLock.unlock();
        }
    }

    void workerDone(Worker w) {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
            if (--poolSize == 0) {
                //tryTerminate();
            }
        } finally {
            mainLock.unlock();
        }
    }

    /**************************************** 线程池中的线程初始化 **************************************************/
    public boolean prestartCoreThread() {
        return addIfUnderCorePoolSize(null); //注意传进去的参数是null
    }

    public int prestartAllCoreThreads() {
        int n = 0;
        while (addIfUnderCorePoolSize(null))//注意传进去的参数是null
            ++n;
        return n;
    }


    private final class Worker implements Runnable {
        private final ReentrantLock runLock = new ReentrantLock();
        private Runnable firstTask;
        volatile long completedTasks;
        Thread thread;

        Worker(Runnable firstTask) {
            this.firstTask = firstTask;
        }

        boolean isActive() {
            return runLock.isLocked();
        }

        void interruptIfIdle() {
            final ReentrantLock runLock = this.runLock;
            if (runLock.tryLock()) {
                try {
                    if (thread != Thread.currentThread())
                        thread.interrupt();
                } finally {
                    runLock.unlock();
                }
            }
        }

        void interruptNow() {
            thread.interrupt();
        }

        private void runTask(Runnable task) {
            final ReentrantLock runLock = this.runLock;
            runLock.lock();
            boolean ran = false;
            try {
                if (runState < STOP && Thread.interrupted() && runState >= STOP)
                    ran = false;
                //beforeExecute(thread, task);   //beforeExecute方法是ThreadPoolExecutor类的一个方法，没有具体实现，用户可以根据
                //自己需要重载这个方法和后面的afterExecute方法来进行一些统计信息，比如某个任务的执行时间等
                try {
                    task.run();
                    ran = true;
                    //afterExecute(task, null);
                    ++completedTasks;
                } catch (RuntimeException ex) {
                    if (!ran)
                        //afterExecute(task, ex);
                        throw ex;
                }
            } finally {
                runLock.unlock();
            }
        }

        public void run() {
            try {
                Runnable task = firstTask;
                firstTask = null;
                while (task != null || (task = getTask()) != null) {
                    runTask(task);
                    task = null;
                }
            } finally {
                workerDone(this);   //当任务队列中没有任务时，进行清理工作
            }
        }


    }

}



