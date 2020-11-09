package com.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HashMapNotSafeTest {

    final Map<Integer, String> map = new HashMap<>();

    final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
    final String targetValue = "v";

    public void test() {
        map.put(targetKey, targetValue);

        new Thread(() -> IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"))).start();

        while (true) {
            if (!targetValue.equals(map.get(targetKey))) {
                System.out.println(map.get(targetKey));
                System.out.println("HashMap is not thread safe.");
                break;
            } else {
                System.out.println("same.");
            }
        }
    }

    public static void main(String[] args) {
        HashMapNotSafeTest test = new HashMapNotSafeTest();
        test.test();
    }

}
