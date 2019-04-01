package com.chapter1.P42;

public class MyThread extends Thread {
	
	private long i = 0;
	
	@Override
	public void run() {
		Long time1 = System.currentTimeMillis();
		for(int j=0; j<100000; j++){
			yield();
			i += 1;
		}
		Long time2 = System.currentTimeMillis();
		System.out.println("run spend time: " + (time2 - time1));
	}

}
