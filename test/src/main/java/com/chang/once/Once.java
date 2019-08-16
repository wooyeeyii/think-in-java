package com.chang.once;

import java.math.BigDecimal;

public class Once {

    public static void main(String[] args) {
        System.out.println(new BigDecimal("0.012234234").setScale(2, BigDecimal.ROUND_CEILING));
        System.out.println(new BigDecimal("0.017324234").setScale(2, BigDecimal.ROUND_CEILING));
        System.out.println(new BigDecimal("0.010000000").setScale(2, BigDecimal.ROUND_CEILING));
        System.out.println(new BigDecimal("0.010067860").setScale(2, BigDecimal.ROUND_CEILING));
    }

}

