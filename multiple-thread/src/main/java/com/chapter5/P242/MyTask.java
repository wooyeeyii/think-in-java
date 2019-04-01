package com.chapter5.P242;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("任务执行了，时间为：" + System.currentTimeMillis() + ", " + new Date());
		try {
			Thread.sleep(10000L);	//RunTest5.java使用
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
