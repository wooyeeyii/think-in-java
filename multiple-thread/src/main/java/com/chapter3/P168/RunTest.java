package com.chapter3.P168;

public class RunTest {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Productor p = new Productor(myStack);
        Consumer c1 = new Consumer(myStack);
        Consumer c2 = new Consumer(myStack);
        Consumer c3 = new Consumer(myStack);
        Consumer c4 = new Consumer(myStack);

        ProductorThread pThread = new ProductorThread(p);
        pThread.start();

        ConsumerThread cThread1 = new ConsumerThread(c1);
        ConsumerThread cThread2 = new ConsumerThread(c2);
        ConsumerThread cThread3 = new ConsumerThread(c3);
        ConsumerThread cThread4 = new ConsumerThread(c4);
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
    }

}
