package com.chang.once;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class Once {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = list.stream().mapToInt(c -> 1).reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum2 = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum2);
        System.out.println(String.valueOf((1 + 1)));
    }

}





