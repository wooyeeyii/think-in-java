package com.chapter4.P202;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("mehtodA run begin." + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("methodA run end.  " + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("mehtodB run begin." + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("methodB run end.  " + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
