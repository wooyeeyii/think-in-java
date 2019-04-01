package com.chapter1.P38;

public class Model {
	
	synchronized public void printString() {
		System.out.println("begin: ");
		if(Thread.currentThread().getName().equals("a")) {
			System.out.println("thread a has been suspend forever. ");
			Thread.currentThread().suspend();
		}
		System.out.println("end. ");
	}

}
