package com.chapter3.P184;

public class ThreadC extends Thread {

    private ThreadB threadB;

    public ThreadC(ThreadB b) {
        this.threadB = b;
    }

    @Override
    public void run() {
        threadB.bService();
    }

}
