package com.chang.observer;

public class SonB extends BaseA {
	
	private C c = new C();
	
	public void notifyC() {
		c.waitForChange();
	}

}
