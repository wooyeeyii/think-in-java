package com.chapter1.P31;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println("thread.interrupted(): " + this.isInterrupted());
            e.printStackTrace();
        }
    }

}
