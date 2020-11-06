package com.examples.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IntIncr {

    public int cnt = 0;

    public void incr() {
        cnt++;
    }

    public static void main(String[] args) throws InterruptedException {
        IntIncr intIncr = new IntIncr();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(intIncr::incr);
        }

        while (true) {
            Thread.sleep(1000);
            System.out.println(intIncr.cnt);
        }
    }
}
