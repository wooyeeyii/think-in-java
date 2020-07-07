package com.chang.once;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Once {

    public static void main(String[] args) throws ParseException {
        BigDecimal a = new BigDecimal("0.1");
        System.out.println(a.toString());
        BigDecimal b = new BigDecimal("0.001");
        System.out.println(b.toString());
        BigDecimal c = new BigDecimal("0.0001");
        System.out.println(c.toString());
        String d = "0.0001";
        MessageFormat messageFormat = new MessageFormat("message {0}, {1}, {2}, {3}");
        System.out.println(messageFormat.format(new Object[]{a, b, c, d}));

        System.out.println(Locale.SIMPLIFIED_CHINESE.toLanguageTag());
    }


}





