package com.chapter3.P169;

public class RunTest {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Productor p1 = new Productor(myStack);
        Productor p2 = new Productor(myStack);
        Productor p3 = new Productor(myStack);
        Productor p4 = new Productor(myStack);
        Consumer c = new Consumer(myStack);

        ProductorThread pThread1 = new ProductorThread(p1);
        ProductorThread pThread2 = new ProductorThread(p2);
        ProductorThread pThread3 = new ProductorThread(p3);
        ProductorThread pThread4 = new ProductorThread(p4);
        pThread1.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();

        ConsumerThread cThread = new ConsumerThread(c);
        cThread.start();
    }

}
