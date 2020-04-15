package com.chapter1.P31;

public class RunTest2 {

    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();
        System.out.println("thread.isAlive():" + thread.isAlive());
        thread.interrupt();
        System.out.println("thread.isAlive():" + thread.isAlive());
    }

}
