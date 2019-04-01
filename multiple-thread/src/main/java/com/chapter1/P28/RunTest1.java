package com.chapter1.P28;

public class RunTest1 {
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		/*try {
			Thread.sleep(1);*/
			System.out.println("thread.isAlive():" + thread.isAlive());
			thread.interrupt();
		/*} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
	}

}
