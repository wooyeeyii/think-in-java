package com.chang.once;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Once {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(dtf.format(ZonedDateTime.now()));
    }


}





