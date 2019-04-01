package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest3 {
	
	public static void main(String[] args) {
		System.out.println("当前时间为：" + new Date());
		Calendar calendarRef = Calendar.getInstance();
		calendarRef.set(Calendar.SECOND, calendarRef.get(Calendar.SECOND) - 10);	//定时时间早于当前时间
		Date runDate = calendarRef.getTime();
		System.out.println("计划时间为：" + runDate);
		
		MyTask myTask = new MyTask();
		Timer timer = new Timer();	
		timer.schedule(myTask, runDate);
		
	}

}
