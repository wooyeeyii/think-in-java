package com.chapter4.P214.notifyAll;

public class ThreadA extends Thread {
	
	private MyService myService;
	
	public ThreadA(MyService service) {
		this.myService = service;
	}
	
	@Override
	public void run() {
		while(true) {
			myService.set();
		}
	}

}
