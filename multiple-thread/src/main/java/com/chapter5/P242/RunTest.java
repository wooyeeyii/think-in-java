package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest {
	
	public static void main(String[] args) {
		System.out.println("当前时间为：" + System.currentTimeMillis());
		Calendar calendarRef = Calendar.getInstance();
		calendarRef.add(Calendar.SECOND, 10);
		Date runDate = calendarRef.getTime();
		
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		timer.schedule(myTask, runDate);
		
	}

}
