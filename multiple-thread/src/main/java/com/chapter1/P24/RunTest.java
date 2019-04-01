package com.chapter1.P24;

public class RunTest {
	
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch.");
			e.printStackTrace();
		}
	}

}
