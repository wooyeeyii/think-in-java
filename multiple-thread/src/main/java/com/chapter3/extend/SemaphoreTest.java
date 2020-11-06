package com.chapter3.extend;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {


    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.methodTest();
    }

    public void methodTest() {
        int count = 50;
        int max_allowed = 3;
        final Semaphore semaphore = new Semaphore(max_allowed);
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(count));

        for (int i = 0; i < count; i++) {
            pool.execute(new MyRunnable(i, semaphore));
        }

        pool.shutdown();
    }


    class MyRunnable implements Runnable {
        int i;
        Semaphore s;

        public MyRunnable(int i, Semaphore s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public void run() {
            try {
                s.acquire();
                System.out.println(i + "-th acquire...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(i + "-th release...");
                s.release();
            }
        }
    }


}
