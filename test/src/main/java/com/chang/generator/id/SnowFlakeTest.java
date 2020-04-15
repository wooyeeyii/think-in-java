package com.chang.generator.id;

public class SnowFlakeTest {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Long.toHexString(SnowFlake.nextId()));
        }
    }


}
