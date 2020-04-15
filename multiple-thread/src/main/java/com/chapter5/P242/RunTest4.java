package com.chapter5.P242;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest4 {

    public static void main(String[] args) {
        System.out.println("��ǰʱ��Ϊ��" + new Date());
        Calendar calendarRef = Calendar.getInstance();
        calendarRef.add(Calendar.SECOND, 10);    //��ʱʱ�����ڵ�ǰʱ��
        Date runDate = calendarRef.getTime();
        System.out.println("�ƻ�ʱ��1Ϊ��" + runDate);

        Calendar calendarRef2 = Calendar.getInstance();
        calendarRef2.add(Calendar.SECOND, 15);    //��ʱʱ�����ڵ�ǰʱ��
        Date runDate2 = calendarRef2.getTime();
        System.out.println("�ƻ�ʱ��2Ϊ��" + runDate2);

        MyTask myTask = new MyTask();
        MyTask myTask2 = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, runDate);
        timer.schedule(myTask2, runDate2);

    }

}
