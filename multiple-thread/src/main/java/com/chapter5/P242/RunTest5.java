package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest5 {

	public static void main(String[] args) {
		System.out.println("当前时间为：" + new Date());
		Calendar calendarRef = Calendar.getInstance();
		calendarRef.add(Calendar.SECOND, 10);	//定时时间早于当前时间
		Date runDate = calendarRef.getTime();
		System.out.println("计划时间1为：" + runDate);

		Calendar calendarRef2 = Calendar.getInstance();
		calendarRef2.add(Calendar.SECOND, 15);	//定时时间早于当前时间
		Date runDate2 = calendarRef2.getTime();
		System.out.println("计划时间2为：" + runDate2);

		MyTask myTask = new MyTask();
		MyTask myTask2 = new MyTask();
		Timer timer = new Timer();
		timer.schedule(myTask, runDate);
		timer.schedule(myTask2, runDate2);

	}

}
