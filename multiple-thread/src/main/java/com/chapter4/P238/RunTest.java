package com.chapter4.P238;

public class RunTest {
	
	public static void main(String[] args) {
		MyService myService = new MyService();
		ThreadA a = new ThreadA(myService);
		a.setName("A");
		
		ThreadB b = new ThreadB(myService);
		b.setName("B");
		a.start();
		b.start();
	}

}
