package com.chapter3.P137;

public class WaitNotifyTest1 {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        ThreadB b = new ThreadB(lock);
        a.start();
        b.start();
    }
}
