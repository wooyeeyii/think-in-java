package com.chapter5.P247;

import java.util.TimerTask;

public class MyTaskA extends TimerTask {
	private int i;
	
	public MyTaskA(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("第" + i + "次没有被cannel取消");
	}

}
