package com.chapter3.P169;

public class ConsumerThread extends Thread {
	
	private Consumer c;
	
	public ConsumerThread(Consumer c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		while(true) {
			c.popService();
		}
	}

}
