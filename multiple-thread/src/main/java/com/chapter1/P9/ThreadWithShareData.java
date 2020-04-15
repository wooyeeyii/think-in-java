package com.chapter1.P9;

public class ThreadWithShareData extends Thread {
    private int count = 10;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("thread: " + currentThread().getName() + ", count = " + count--);
        }
    }

}
