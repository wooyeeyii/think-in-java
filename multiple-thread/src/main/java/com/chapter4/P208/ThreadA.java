package com.chapter4.P208;

public class ThreadA extends Thread {
	
	private MyService myService;
	
	public ThreadA(MyService service) {
		this.myService = service;
	}
	
	@Override
	public void run() {
		myService.awaitA();
	}

}
