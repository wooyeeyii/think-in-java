package com.chapter3.extend.future;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class MyFutureTask<V> implements RunnableFuture<V> {

    private Callable<V> callable;

    // new 0, completing 1, normal 2, exceptional 3, cancelled 4, interrupting 5, unterrupted 6;
    private volatile int state;

    private Object result;

    private volatile Thread thread;

    private volatile WaitNode waiters;

    public MyFutureTask(Callable c) {
        if (c == null)
            throw new NullPointerException();
        this.callable = c;
        this.state = 0;
    }


    @Override
    public void run() {
        if (!(0 == state) || !UNSAFE.compareAndSwapObject(this, threadShift, null, Thread.currentThread())) {
            return;
        }

        try {
            if (null != callable && 0 == state) {
                V result = callable.call();
                set(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            setException(ex);
        } finally {
            // runner must be non-null until state is settled to
            // prevent concurrent calls to run()
            thread = null;
            // state must be re-read after nulling runner to prevent
            // leaked interrupts
            int s = state;
            if (s >= 5)
                handlePossibleCancellationInterrupt(s);
        }

    }

    protected void set(V v) {
        if (UNSAFE.compareAndSwapInt(this, stateShift, 0, 1)) {
            result = v;
            UNSAFE.putOrderedInt(this, stateShift, 2); // final state
            finishCompletion();
        }
    }

    protected void setException(Throwable t) {
        if (UNSAFE.compareAndSwapInt(this, stateShift, 0, 1)) {
            result = t;
            UNSAFE.putOrderedInt(this, stateShift, 3); // final state
            finishCompletion();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!(0 == state) || !(UNSAFE.compareAndSwapInt(this, stateShift, 0, (mayInterruptIfRunning ? 5 : 4)))) {
            return false;
        }

        try {
            if (mayInterruptIfRunning) {
                try {
                    Thread t = this.thread;
                    if (null != t)
                        t.interrupt();
                } finally {
                    // 立即写入主存，变量必须是volatile的
                    UNSAFE.putOrderedInt(this, stateShift, 6);
                }
            }
        } finally {
            finishCompletion();
        }
        return true;
    }

    @Override
    public boolean isCancelled() {
        return state >= 4;
    }

    @Override
    public boolean isDone() {
        return state > 0;
    }

    private V report(int s) throws ExecutionException {
        Object x = result;
        if (s == 2)
            return (V) x;
        if (s >= 4)
            throw new CancellationException();
        throw new ExecutionException((Throwable) x);
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        int s = state;
        if (s <= 1) {
            s = awaitDone(false, 0L);
        }
        return report(s);
    }


    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (unit == null)
            throw new NullPointerException();
        int s = state;
        if (s <= 1 &&
                (s = awaitDone(true, unit.toNanos(timeout))) <= 1) {
            throw new TimeoutException();
        }
        return report(s);
    }

    private int awaitDone(boolean timed, long nanos)
            throws InterruptedException {
        final long deadline = timed ? System.nanoTime() + nanos : 0L;
        WaitNode q = null;
        boolean queued = false;
        for (; ; ) {
            if (Thread.interrupted()) {
                removeWaiter(q);
                throw new InterruptedException();
            }

            int s = state;
            if (s > 1) {    // 若已经出结果，则直接返回
                if (q != null)
                    q.thread = null;
                return s;
            } else if (s == 1) // cannot time out yet
                Thread.yield();
            else if (q == null)
                q = new WaitNode(); // 创建当前线程的waitNode，下次就可以入链表了
            else if (!queued)   // 加入链表头部
                queued = UNSAFE.compareAndSwapObject(this, waitersShift,
                        q.next = waiters, q);
            else if (timed) {
                nanos = deadline - System.nanoTime();
                if (nanos <= 0L) {
                    removeWaiter(q);    //清理整个链表中无效的节点
                    return state;
                }
                LockSupport.parkNanos(this, nanos);
            } else
                LockSupport.park(this);
        }
    }

    private void handlePossibleCancellationInterrupt(int s) {
        // It is possible for our interrupter to stall before getting a
        // chance to interrupt us.  Let's spin-wait patiently.
        if (s == 5)
            while (state == 5)
                Thread.yield(); // wait out pending interrupt

        // assert state == INTERRUPTED;

        // We want to clear any interrupt we may have received from
        // cancel(true).  However, it is permissible to use interrupts
        // as an independent mechanism for a task to communicate with
        // its caller, and there is no way to clear only the
        // cancellation interrupt.
        //
        // Thread.interrupted();
    }

    static final class WaitNode {
        volatile Thread thread;
        volatile WaitNode next;

        WaitNode() {
            thread = Thread.currentThread();
        }
    }

    private void removeWaiter(WaitNode node) {
        if (node != null) {
            node.thread = null;
            retry:
            for (; ; ) {          // restart on removeWaiter race
                for (WaitNode pred = null, q = waiters, s; q != null; q = s) {
                    s = q.next;
                    if (q.thread != null)
                        pred = q;
                    else if (pred != null) {
                        pred.next = s;
                        if (pred.thread == null) // check for race
                            continue retry;
                    } else if (!UNSAFE.compareAndSwapObject(this, waitersShift,
                            q, s))
                        continue retry;
                }
                break;
            }
        }
    }

    // 释放waiters中的对象, 线程继续运行
    private void finishCompletion() {
        // assert state > COMPLETING;
        for (WaitNode q; (q = waiters) != null; ) {
            if (UNSAFE.compareAndSwapObject(this, waitersShift, q, null)) {
                for (; ; ) {
                    Thread t = q.thread;
                    if (t != null) {
                        q.thread = null;
                        LockSupport.unpark(t);
                    }
                    WaitNode next = q.next;
                    if (next == null)
                        break;
                    q.next = null; // unlink to help gc
                    q = next;
                }
                break;
            }
        }

        done();

        callable = null;        // to reduce footprint
    }

    protected void done() {
    }


    // Unsafe mechanics
    private static final sun.misc.Unsafe UNSAFE;
    private static final long stateShift;
    private static final long threadShift;
    private static final long waitersShift;

    static {
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            UNSAFE = (Unsafe) singleoneInstanceField.get(null);
            // 下面的获取方式报安全错误
//            UNSAFE = sun.misc.Unsafe.getUnsafe();

            Class<?> c = MyFutureTask.class;
            stateShift = UNSAFE.objectFieldOffset(c.getDeclaredField("state"));
            threadShift = UNSAFE.objectFieldOffset(c.getDeclaredField("thread"));
            waitersShift = UNSAFE.objectFieldOffset(c.getDeclaredField("waiters"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }


}
