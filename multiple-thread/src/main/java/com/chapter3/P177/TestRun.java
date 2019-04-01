package com.chapter3.P177;

public class TestRun {
	
	public static void main(String[] args) {
		DBTools dbTools = new DBTools();
		ThreadA[] threadA = new ThreadA[10];
		ThreadB[] threadB = new ThreadB[10];
		
		for(int i=0; i<10; i++) {
			threadA[i] = new ThreadA(dbTools);
			threadB[i] = new ThreadB(dbTools);
			
			threadA[i].start();
			threadB[i].start();
		}
		
	}

}
