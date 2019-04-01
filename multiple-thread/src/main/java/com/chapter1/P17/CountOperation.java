package com.chapter1.P17;

public class CountOperation extends Thread {
	
	public CountOperation() {
		System.out.println("CountOperation--begin");
		System.out.println("Thread.currentThread.getName(): " + Thread.currentThread().getName());
		System.out.println("Thread.currentThread.isAlive(): " + Thread.currentThread().isAlive());
		System.out.println("this.getName(): " + this.getName());
		System.out.println("this.isAlive(): " + this.isAlive());
		System.out.println("CountOperation--end");
	}
	
	@Override
	public void run() {
		System.out.println("run--begin");
		System.out.println("Thread.currentThread.getName(): " + Thread.currentThread().getName());
		System.out.println("Thread.currentThread.isAlive(): " + Thread.currentThread().isAlive());
		try {
			System.out.println("thread sleep().");
			Thread.sleep(3000);
			System.out.println("thread sleep() over.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this.getName(): " + this.getName());
		System.out.println("this.isAlive(): " + this.isAlive());
		System.out.println("run--end");
	}

}
