package com.chang.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LocalDateTimeTest {

    public void test() {
        /* LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));

        ZonedDateTime zonedDateTime = zdt.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(Date.from(zonedDateTime.toInstant()));*/

        LocalDateTime datetime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(datetime);
        ZonedDateTime zdtt = datetime.atZone(ZoneId.systemDefault());
        System.out.println(zdtt);
        System.out.println(Date.from(zdtt.toInstant()));
    }

    public static void main(String[] args) {
        LocalDateTimeTest localDateTimeTest = new LocalDateTimeTest();
        localDateTimeTest.test();
    }


}
