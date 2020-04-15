package com.chapter4.P219;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    public ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /************************************************************************************/
    public void getHoldCountMethod1() {
        try {
            lock.lock();
            System.out.println("serviceMethod1 before get lock again, getHoldCount=" + lock.getHoldCount());
            getHoldCountMethod2();
            System.out.println("serviceMethod1 after release lock once, getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

    public void getHoldCountMethod2() {
        try {
            lock.lock();
            System.out.println("serviceMethod2 getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }


    /************************************************************************************/
    public void getQueueLengthMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " ���뷽����");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /************************************************************************************/
    public void getWaitQueueLengthMethod1() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("��" + lock.getWaitQueueLength(condition) + " ���߳����ڵȴ�condition");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}












