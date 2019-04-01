package com.chapter3.P170;

public class RunTest {
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		Productor p1 = new Productor(myStack);
		Productor p2 = new Productor(myStack);
		Productor p3 = new Productor(myStack);
		Productor p4 = new Productor(myStack);
		Consumer c1 = new Consumer(myStack);
		Consumer c2 = new Consumer(myStack);
		Consumer c3 = new Consumer(myStack);
		Consumer c4 = new Consumer(myStack);
		Consumer c5 = new Consumer(myStack);
		
		
		ProductorThread pThread1 = new ProductorThread(p1);
		ProductorThread pThread2 = new ProductorThread(p2);
		ProductorThread pThread3 = new ProductorThread(p3);
		ProductorThread pThread4 = new ProductorThread(p4);
		pThread1.start();
		pThread2.start();
		pThread3.start();
		pThread4.start();
		
		ConsumerThread cThread1 = new ConsumerThread(c1);
		ConsumerThread cThread2 = new ConsumerThread(c2);
		ConsumerThread cThread3 = new ConsumerThread(c3);
		ConsumerThread cThread4 = new ConsumerThread(c4);
		ConsumerThread cThread5 = new ConsumerThread(c5);
		cThread1.start();
		cThread2.start();
		cThread3.start();
		cThread4.start();
		cThread5.start();
	}

}
