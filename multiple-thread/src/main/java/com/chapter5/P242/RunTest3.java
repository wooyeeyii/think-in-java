package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest3 {

    public static void main(String[] args) {
        System.out.println("��ǰʱ��Ϊ��" + new Date());
        Calendar calendarRef = Calendar.getInstance();
        calendarRef.set(Calendar.SECOND, calendarRef.get(Calendar.SECOND) - 10);    //��ʱʱ�����ڵ�ǰʱ��
        Date runDate = calendarRef.getTime();
        System.out.println("�ƻ�ʱ��Ϊ��" + runDate);

        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, runDate);

    }

}
