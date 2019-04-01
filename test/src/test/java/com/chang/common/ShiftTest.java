package com.chang.common;

import org.junit.Test;

public class ShiftTest {

    @Test
    public void test1() {
        Integer a = -2;
        Integer b = 2;
        System.out.println(a << 1);
        System.out.println(a >> 1);
        System.out.println(a >>> 1);
        System.out.println(b << 1);
        System.out.println(b >> 1);
        System.out.println(b >>> 1);
    }

    @Test
    public void test2() {
        String[] a = new String[] {"aaa", null, ""};
        for(String s : a) {
            System.out.println("##################");
            if(s instanceof String) {
                System.out.println(s);
            } else {
                System.out.println("not string");
            }
            System.out.println("-------------------");
        }
        Integer b = null;
        if((Object)b instanceof String) {
            System.out.println("b is String");
        } else if((Object)b instanceof Integer) {
            System.out.println("b is Integer");
        } else {
            System.out.println("b is null");
        }
    }
}
