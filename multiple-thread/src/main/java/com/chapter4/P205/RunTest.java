package com.chapter4.P205;

public class RunTest {

    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);

        threadA.start();
    }

}
