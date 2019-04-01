package com.chapter4.P213;

public class ThreadB extends Thread {
	
	private MyService myService;
	
	public ThreadB(MyService service) {
		this.myService = service;
	}
	
	@Override
	public void run() {
		while(true) {
			myService.get();
		}
	}

}