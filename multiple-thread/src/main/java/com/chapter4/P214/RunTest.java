package com.chapter4.P214;

public class RunTest {
	public static void main(String[] args) throws InterruptedException {
		MyService myService = new MyService();
		ThreadA[] threadA = new ThreadA[10];
		ThreadB[] threadB = new ThreadB[10];
		
		for(int i=0; i<10; i++) {
			threadA[i] = new ThreadA(myService);
			threadB[i] = new ThreadB(myService);
			threadA[i].start();
			threadB[i].start();
		}
		
	}
}
