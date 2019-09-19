package com.chang.once;

import java.math.BigDecimal;

public class Once {

    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("213.234");
        System.out.println(b.setScale(-10, BigDecimal.ROUND_HALF_DOWN));
    }

}

