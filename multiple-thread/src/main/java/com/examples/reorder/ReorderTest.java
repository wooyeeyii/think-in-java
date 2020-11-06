package com.examples.reorder;

public class ReorderTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            ReorderExample example = new ReorderExample();
            Runnable b = () -> example.writer();
            new Thread(b).start();
            Runnable a = () -> example.reader();
            new Thread(a).start();
        }

        ReorderExample.map.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }

}
