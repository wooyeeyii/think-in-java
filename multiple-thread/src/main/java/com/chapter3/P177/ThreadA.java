package com.chapter3.P177;

public class ThreadA extends Thread {
	
	private DBTools dbTools;
	
	public ThreadA(DBTools dbTools) {
		super();
		this.dbTools = dbTools;
	}
	
	@Override
	public void run() {
		while(true) {
			dbTools.backupA();
		}
	}

}
