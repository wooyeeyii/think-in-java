package com.chapter1.P25;

public class RunTest1 {
	
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			System.out.println("Thread.interrupted(): " + Thread.interrupted());	//当前线程的中断状态  
			System.out.println("Thread.interrupted(): " + Thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		
		System.out.println("end!");
	}

}
