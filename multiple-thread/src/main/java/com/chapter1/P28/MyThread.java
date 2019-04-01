package com.chapter1.P28;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		super.run();
		for(int i=0; i<500000; i++) {
			if(this.isInterrupted()) {
				System.out.println("已经是停止状态了！即将退出!");
				break;
			}
			//System.out.println("i = " + i);
		}
		//中断后续的代码是否需要执行的问题(一般应该是不能执行的)
		System.out.println("last statement in MyThread.run()");
	}

}
