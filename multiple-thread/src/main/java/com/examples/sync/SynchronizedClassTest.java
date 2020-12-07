package com.examples.sync;

public class SynchronizedClassTest {

    public static synchronized void method() {
        System.out.println("method start....");
        try {
            System.out.println("method sleep....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method end....");
    }

    public static void main(String[] args) {
        // 锁的就是方法区保存的.class对象
        new Thread(SynchronizedClassTest::method).start();
        new Thread(SynchronizedClassTest::method).start();
        new Thread(SynchronizedClassTest::method).start();
    }
}
