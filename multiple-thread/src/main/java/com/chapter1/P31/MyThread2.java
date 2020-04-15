package com.chapter1.P31;

public class MyThread2 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            ;
        }
        System.out.println("thread is going to sleep. thread.interrupted(): " + this.isInterrupted());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println("thread.interrupted(): " + this.isInterrupted());
            e.printStackTrace();
        }
    }

}
