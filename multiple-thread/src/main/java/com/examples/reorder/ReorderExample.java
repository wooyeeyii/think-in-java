package com.examples.reorder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReorderExample {

    public static final Map<Integer, Integer> map = new ConcurrentHashMap<>();

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;                   //1
        flag = true;             //2
    }

    public void reader() {
        if (flag) {                //3
            int i = a * a;         //4
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

}
