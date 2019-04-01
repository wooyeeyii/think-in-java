package com.chapter4.P237;

public class ThreadB extends Thread {
	
	private MyService myService;
	
	public ThreadB(MyService myService) {
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.write();
	}

}
