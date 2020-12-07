package com.chang.once;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Once {

    public static void main(String[] args) {
        System.out.println(new BigDecimal("10073361").divide(new BigDecimal(100000000), 8, RoundingMode.DOWN));
        int[] intArray = new int[]{1, 2, 3, 4};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] listConvert = list.toArray(Integer[]::new);

    }

}





