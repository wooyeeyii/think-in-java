package com.chapter7.P283;

public class RunTest {

    //NEW;
    //RUNNABLE;
    //TERMINATED;
    //BLOCKED;
    //WAITING;
    //TIMED_WAITING;
    public static void main(String[] args) {
        MyThreadA a1 = new MyThreadA();
        a1.setName("a1");
        a1.start();
        MyThreadA a2 = new MyThreadA();
        a2.setName("a2");
        a2.start();
        System.out.println("main方法中的状态, a1: " + a1.getState());
        System.out.println("main方法中的状态, a2: " + a2.getState());
    }

}
