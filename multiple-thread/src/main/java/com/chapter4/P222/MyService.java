package com.chapter4.P222;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    /************************************************************************************/
    public void waitMethod() {
        try {
            lock.lock();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void conditionWatiMehod() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notityMehtod() {
        try {
            lock.lock();
            System.out.println("有没有线程正在等待condition？ " + lock.hasWaiters(condition) + " 线程数是多少？ " +
                    lock.getWaitQueueLength(condition));
            condition.signal();
            System.out.println("after condition.signal 有没有线程正在等待condition？ " + lock.hasWaiters(condition) + " 线程数是多少？ " +
                    lock.getWaitQueueLength(condition));
        } finally {
            lock.unlock();
        }
    }

}












