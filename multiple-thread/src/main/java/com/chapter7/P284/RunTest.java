package com.chapter7.P284;

public class RunTest {

    //NEW;
    //RUNNABLE;
    //TERMINATED;
    //BLOCKED;
    //WAITING;
    //TIMED_WAITING;
    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的状态：" + t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
