package com.multi.thread;

public class TestRun {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread thread1 = new MyThread();
		
		thread1.start();
		Thread.sleep(1000);
		thread1.interrupt();
		
		//thread1.interrupted();
		System.out.println("1. " + Thread.interrupted());
		System.out.println("2. " + Thread.interrupted());
	}

}
