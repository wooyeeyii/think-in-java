package com.chapter1.P38;

public class RunTest1 {
	
	public static void main(String[] args) {
		try {
			final Model model = new Model();
			Thread thread1 = new Thread() {
				@Override
				public void run() {
					model.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			
			Thread thread2 = new Thread() {
				@Override
				public void run() {
					System.out.println("thread2 start. but can not enter function printString().");
					System.out.println("because function printString has been locked by thread. And suspend forever. ");
					
					model.printString();
				}
			};
			thread2.start();
		} catch (InterruptedException e ) {
			e.printStackTrace();
		}
		
	}

}
