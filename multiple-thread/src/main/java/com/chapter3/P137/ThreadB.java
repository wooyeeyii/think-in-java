package com.chapter3.P137;

public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("begin notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("end notify time = " + System.currentTimeMillis());
        }
    }
}
