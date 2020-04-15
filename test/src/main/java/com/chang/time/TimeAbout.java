package com.chang.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeAbout {

    static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        aboutDate();
        aboutLong();
        aboutCalendar();
        aboutString();
    }

    public static void aboutDate() {
        Date currentTime = new Date();
        //date转化为string
        String dateString = dateformat.format(currentTime);
        System.out.println("data turn into string: " + dateString);

        //date转化为long
        long datesec = currentTime.getTime();
        System.out.println("data turn into long: " + datesec);

        //date转化为calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        System.out.println("data turn into calendar: " + calendar);
        System.out.println("long turn into calendar.get(calendar.YEAR): " + calendar.get(calendar.YEAR));

        System.out.println("-----------------------");
    }

    public static void aboutLong() {
        //返回自1970年1月1日00:00:00GMT以来的毫秒数。
        long msec = System.currentTimeMillis();
        System.out.println("long itself: " + msec);

        //long转化为string
        String msecString = dateformat.format(msec);
        System.out.println("long turn into string: " + msecString);

        //long转化为DATE
        Date longToDate = new Date(msec);
        System.out.println("long turn into date: " + longToDate);

        //long转化为calendar
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(msec);
        System.out.println("long turn into calendar: " + ca);
        System.out.println("long turn into calendar.get(ca.YEAR): " + ca.get(ca.YEAR));

        System.out.println("-----------------------");
    }

    public static void aboutCalendar() {
        Calendar calendar = Calendar.getInstance();
        /* 下面设置的日期为2016年5月1日 */
        calendar.set(2016, 4, 1);  //改变年月日，
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        //calendar转化为date
        Date date = calendar.getTime();
        System.out.println("calendar turn into date: " + date);

        //calendar转化为long
        long time = calendar.getTimeInMillis();
        System.out.println("calendar turn into long: " + time);

        System.out.println("-----------------------");
    }

    public static void aboutString() throws ParseException {
        //String 转化Date
        String str = "2010-5-27";
        SimpleDateFormat dataStr = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dataStr.parse(str);
        System.out.println("string turn into date: " + birthday);
    }

}
