package com.multi.thread.daemon;

public class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while (true) {
                i++;
                System.out.println("i = " + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
