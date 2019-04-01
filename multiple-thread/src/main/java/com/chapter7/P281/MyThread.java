package com.chapter7.P281;

public class MyThread extends Thread {
	
	public MyThread() {
		System.out.println("构造方法中的状态: " + Thread.currentThread().getState());
	}
	
	@Override
	public void run() {
		System.out.println("run 方法中的状态: " + Thread.currentThread().getState());
	}

}
