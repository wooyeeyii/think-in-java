package com.chapter1.P38;

public class RunTest2 {

    public static void main(String[] args) {
        System.out.println("main start.");
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(1000);
            thread.suspend();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("main end.");
    }

}
