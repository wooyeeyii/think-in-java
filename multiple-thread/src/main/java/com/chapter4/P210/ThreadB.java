package com.chapter4.P210;

public class ThreadB extends Thread {
	
	private MyService myService;
	
	public ThreadB(MyService service) {
		this.myService = service;
	}
	
	@Override
	public void run() {
		myService.awaitB();
	}

}