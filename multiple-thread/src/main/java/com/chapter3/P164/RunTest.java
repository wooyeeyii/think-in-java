package com.chapter3.P164;

public class RunTest {
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		Productor p = new Productor(myStack);
		Consumer c = new Consumer(myStack);
		
		ProductorThread pThread = new ProductorThread(p);
		ConsumerThread cThread = new ConsumerThread(c);
		
		pThread.start();
		cThread.start();
		
	}

}
