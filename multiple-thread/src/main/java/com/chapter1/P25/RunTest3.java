package com.chapter1.P25;

public class RunTest3 {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5);
            thread.interrupt();
            System.out.println("thread.isAlive():" + thread.isAlive());
            System.out.println("thread.interrupted(): " + thread.isInterrupted());
            System.out.println("thread.interrupted(): " + thread.isInterrupted());
            System.out.println("thread.isAlive():" + thread.isAlive());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end!");
    }

}
