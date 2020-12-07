package com.examples.sync;

public class SynchronizedObjectTest {

    private final Object a = new Object();

    private final Object b = new Object();

    public void method1() {
        synchronized (a) {
            System.out.println("method1 start....");
            try {
                System.out.println("method1 sleep....");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1 end....");
        }
    }

    public void method2() {
        synchronized (b) {
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
        SynchronizedObjectTest synchronizedObjectTest = new SynchronizedObjectTest();
        new Thread(synchronizedObjectTest::method1).start();
        new Thread(synchronizedObjectTest::method2).start();
    }
}
