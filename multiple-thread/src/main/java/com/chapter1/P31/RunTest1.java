package com.chapter1.P31;

public class RunTest1 {
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		try {
			Thread.sleep(1000);
			System.out.println("thread.isAlive():" + thread.isAlive());
			thread.interrupt();
			System.out.println("thread.isAlive():" + thread.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
