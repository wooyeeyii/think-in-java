package com.chapter1.P38;

public class MyThread extends Thread {
	
	private long i = 0;
	private long tmp = 0;
	
	@Override
	public void run() {
		while (true) {
			i += 1;

			System.out.println("i = " + i);
		}
	}

}
