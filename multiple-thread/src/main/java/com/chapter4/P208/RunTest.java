package com.chapter4.P208;

public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.start();
        threadB.start();

        Thread.sleep(2000);
        myService.signalAll();
    }

}
