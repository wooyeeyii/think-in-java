package com.chapter7.P286;

public class ThreadA extends Thread {
	
	@Override
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println("ThreadName=" + Thread.currentThread().getName());
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
