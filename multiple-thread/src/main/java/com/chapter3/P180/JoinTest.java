package com.chapter3.P180;

public class JoinTest {

    public static void main(String[] args) throws Exception {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();

            threadTest.join();
            System.out.println("main thread continue after threadTest. I did it. ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
