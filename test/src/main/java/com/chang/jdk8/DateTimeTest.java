package com.chang.jdk8;

import java.time.*;

public class DateTimeTest {

    // 不涉及时区
    public void localDateTimeTest() {
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("年：" + year + ", 月: " + month + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(9).withYear(2099);
        System.out.println("date2: " + date2);

        // 12 december 2019
        LocalDate date3 = LocalDate.of(2019, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 10 小时 10 分钟 59 s
        LocalTime date4 = LocalTime.of(10, 10, 59);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    // 时区
    public void zonedDateTimeTest() {
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime
                .parse("2019-03-27T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

    public static void main(String[] args) {
        DateTimeTest time = new DateTimeTest();
        time.localDateTimeTest();
        System.out.println("=========================");
        time.zonedDateTimeTest();
    }
}
