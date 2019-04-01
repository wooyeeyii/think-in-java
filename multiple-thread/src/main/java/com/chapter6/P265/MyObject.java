package com.chapter6.P265;

public class MyObject {
	private static MyObject myObject = null;
	
	private MyObject() {}
	
	public static MyObject getInstance() {
		//延迟加载
		if(null == myObject) {
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 myObject = new MyObject();
		}
		return myObject;
	}

}
