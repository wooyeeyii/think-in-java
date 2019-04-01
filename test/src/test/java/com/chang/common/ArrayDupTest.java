package com.chang.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDupTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<String>();
        String a = "abc";
        list.add(a);
        list.add(a);
        System.out.print(list.get(0) == list.get(1));
    }

    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2)
                list.remove(integer);
        }
    }
}
