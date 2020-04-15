package com.multi.thread;

public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        //System.out.println("i= " + (i--) +" thread name: " + Thread.currentThread().getName());
        for (; i < 500000; i++) {
            //System.out.println("i= " + i);
            ;
        }
    }
}
