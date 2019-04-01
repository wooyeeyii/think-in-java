package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest2 {

	public static void main(String[] args) {
		System.out.println("当前时间为：" + System.currentTimeMillis());
		Calendar calendarRef = Calendar.getInstance();
		calendarRef.add(Calendar.SECOND, 10);
		Date runDate = calendarRef.getTime();

		MyTask myTask = new MyTask();
		Timer timer = new Timer(true);	//守护线程
		timer.schedule(myTask, runDate);

	}

}
