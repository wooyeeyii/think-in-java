package com.chapter3.P184;

public class JoinTest {
	
	public static void main(String[] arags) {
		try {
			ThreadB b = new ThreadB();
			ThreadD d = new ThreadD(b);
			d.start();
			Thread.sleep(1000);
			ThreadC c = new ThreadC(b);
			c.start();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
