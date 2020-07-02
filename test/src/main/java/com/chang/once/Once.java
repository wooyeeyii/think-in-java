package com.chang.once;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Once {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = format.parse("2020-07-01");
        int days = (int) ((endDate.getTime() - new Date().getTime()) / (1000 * 3600 * 24)) + 1;
        days = days < 0 ? 0 : days;
        System.out.println(String.format("剩余%s天", days));
    }


}





