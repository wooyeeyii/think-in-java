package com.chapter4.P210;

public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB1 = new ThreadB(myService);
        ThreadB threadB2 = new ThreadB(myService);
        threadA.start();
        threadB1.start();
        threadB2.start();

        Thread.sleep(2000);
        myService.signalA();
        Thread.sleep(2000);
        myService.signalBAll();
    }

}
