package com.chapter3.P187;

public class ThreadB extends Thread {

    @Override
    synchronized public void run() {
        try {
            System.out.println("B run begin." + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("B run end.  " + Thread.currentThread().getName() + ", time= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
