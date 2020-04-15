package com.chapter1.P9;

public class ThreadWithPrivateData extends Thread {
    private int count = 5;

    public ThreadWithPrivateData(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("thread: " + currentThread().getName() + ", count = " + count--);
        }
    }

}
