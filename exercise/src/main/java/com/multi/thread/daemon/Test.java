package com.multi.thread.daemon;

public class Test {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("I have left, so the print action of MyThread will stop too. ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
