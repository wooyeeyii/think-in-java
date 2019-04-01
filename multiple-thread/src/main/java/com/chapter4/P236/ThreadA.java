package com.chapter4.P236;

public class ThreadA extends Thread {
	
	private MyService myService;
	
	public ThreadA(MyService myService) {
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.read();
	}

}
