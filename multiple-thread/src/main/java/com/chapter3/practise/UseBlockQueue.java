package com.chapter3.practise;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class UseBlockQueue {

    private static AtomicInteger count = new AtomicInteger();
    private BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(10);

    private boolean isRunning = true;

    private void start() {

        Runnable prodR = () -> {
            System.out.println("producer id = " + Thread.currentThread().getId());

            while (isRunning) {
                try {
                    Thread.sleep(1000);
                    queue.put(count.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable conT = () -> {
            System.out.println("customer id = " + Thread.currentThread().getId());

            while (isRunning) {
                try {
                    Integer data = queue.take();
                    if (null != data) {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getId() + " data is " + data + " done!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new Thread(prodR));
        }

        for (int i = 0; i < 2; i++) {
            es.execute(new Thread(conT));
        }
    }

    public static void main(String[] args) {
        UseBlockQueue queue = new UseBlockQueue();
        queue.start();
    }


}
