package com.chapter7.P282;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("begin sleep()....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("after sleep()....");
    }

}
