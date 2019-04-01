package com.chapter1.P38;

public class MyObject {
	
	private String username = "1";
	private String password = "11";
	
	public void setValue(String u, String p) {
		this.username = u;
		if(Thread.currentThread().getName().equals("a")) {
			System.out.println("thread a has been suspend forever. ");
			Thread.currentThread().suspend();
		}
		this.password = p;
	}
	
	public void printInfo() {
		System.out.println(String .format("username: %s, password: %s", username, password));
	}

}
