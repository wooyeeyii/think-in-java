package com.chapter4.P216;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private boolean isFair = false;

    private Lock lock = null;
    private Condition condition = null;

    private boolean hasValue = false;

    public MyService(boolean isFair) {
        this.isFair = isFair;
        lock = new ReentrantLock(isFair);
        condition = lock.newCondition();
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " �������.");
        } finally {
            lock.unlock();
        }
    }

}
