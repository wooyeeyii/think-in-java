package com.chapter1.P33;

public class Model {
	
	private String username = "a";
	
	private String password = "aa";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	synchronized public void printString(String username, String password) {
		try {
			this.username = username;
			Thread.sleep(10000000);
			this.password = password;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
