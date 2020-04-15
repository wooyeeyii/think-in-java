package com.chapter5.P247;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class RunTest6 {

    public static void main(String[] args) {
        int i = 0;
        Calendar calendarRef1 = Calendar.getInstance();
        Date runDate1 = calendarRef1.getTime();

        while (true) {
            i++;
            Timer timer = new Timer();
            MyTaskA task1 = new MyTaskA(i);
            timer.schedule(task1, runDate1);
            timer.cancel();
        }
    }

}
