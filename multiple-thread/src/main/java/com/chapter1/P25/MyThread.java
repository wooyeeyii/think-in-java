package com.chapter1.P25;

public class MyThread extends Thread {
	
	Long count = 0L;
	
	@Override
	public void run() {
		super.run();
		for(int i=0; i<500000; i++) {
			count += i;
			//System.out.println("thread.isAlive():" + this.isAlive());;
		}
	}

}
