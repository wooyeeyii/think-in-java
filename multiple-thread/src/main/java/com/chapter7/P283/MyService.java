package com.chapter7.P283;

public class MyService {
	
	synchronized static public void serviceMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + "进入了业务方法.");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
