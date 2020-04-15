package com.multi.thread;

public class DeadThreadTest {

    public static void main(String[] args) throws InterruptedException {
        DeadThread dt1 = new DeadThread();
        dt1.setFlag("a");

        Thread t1 = new Thread(dt1);
        t1.start();

        Thread.sleep(100);

        dt1.setFlag("b");
        Thread t2 = new Thread(dt1);
        t2.start();

    }

}
