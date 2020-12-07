package com.examples.sync;

public class SynchronizedThisTest {

    public synchronized void method1() {
        System.out.println("method1 start....");
        try {
            System.out.println("method1 sleep....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1 end....");
    }

    public void method2() {
        synchronized (this) {
            System.out.println("method2 start....");
            try {
                System.out.println("method2 sleep....");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method2 end....");
        }
    }

    public static void main(String[] args) {
        // 锁的就是下面生成的对象
        SynchronizedThisTest synchronizedThisTest = new SynchronizedThisTest();
        new Thread(synchronizedThisTest::method1).start();
        new Thread(synchronizedThisTest::method2).start();
    }

}
