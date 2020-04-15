package com.chapter4.P207;

public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }

}
