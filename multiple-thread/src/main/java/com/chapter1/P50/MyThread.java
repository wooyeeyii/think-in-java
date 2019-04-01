package com.chapter1.P50;

public class MyThread extends Thread {
	
	private long i = 0;
	
	@Override
	public void run() {
		try {
			while(true) {
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
