package com.chapter1.P17;

public class RunTest {
	
	public static void main(String[] args) {
		CountOperation c = new CountOperation();
		Thread t1 = new Thread(c);
		t1.setName("A");
		t1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("t1.isAlive(): " + t1.isAlive());
	}

}
