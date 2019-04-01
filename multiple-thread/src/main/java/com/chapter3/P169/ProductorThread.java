package com.chapter3.P169;

public class ProductorThread extends Thread {

	private Productor p;
	
	public ProductorThread(Productor p) {
		super();
		this.p = p;
	}
	
	@Override
	public void run() {
		while(true) {
			p.pushService();
		}
	}
	
}
