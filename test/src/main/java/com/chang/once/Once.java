package com.chang.once;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Once {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2020-09-02", dateTimeFormatter);
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        System.out.println(ZoneId.systemDefault());
        Date jobDate = Date.from(zonedDateTime.toInstant());
        System.out.println(jobDate);

        System.out.println(new Date());
    }


}





