package com.multi.thread;

public class DeadThread implements Runnable {
	
	public String userName;
	
	public Object object1 = new Object();
	public Object object2 = new Object();
	
	public void setFlag(String str) {
		this.userName = str;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(userName.equals("a")) {
			synchronized(object1) {
				System.out.println("userName = " + userName + ", run begin. got object1 lock.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized(object2) {
					System.out.println("userName = " + userName + ", run begin. got object1 lock.");
				}
			}
		}
		
		if(userName.equals("b")) {
			synchronized(object2) {
				System.out.println("userName = " + userName + ", run begin. got object2 lock.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized(object1) {
					System.out.println("userName = " + userName + ", run begin. got object1 lock.");
				}
			}
		}
		
		
	}

}
