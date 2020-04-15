package com.chapter3.extend;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {


    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();

        countDownLatchTest.methodTest();
    }

    public void methodTest() {
        int countWait = 3;
        int countGo = 2;

        final CountDownLatch countDownLatch = new CountDownLatch(countWait);
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 5, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(countWait));    //


        for (int i = 0; i < countWait; i++) {
            pool.execute(new MyWaitRunnable(i, countDownLatch));
        }

        for (int i = 0; i < countGo; i++) {
            pool.execute(new MyGoRunnable(i, countDownLatch));
        }

        pool.shutdown();
    }

    class MyWaitRunnable implements Runnable {
        CountDownLatch cdl;
        int i;

        public MyWaitRunnable(int i, CountDownLatch cdl) {
            this.i = i;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println(i + "-th wait...");
            cdl.countDown();
        }
    }

    class MyGoRunnable implements Runnable {
        CountDownLatch cdl;
        int i;

        public MyGoRunnable(int i, CountDownLatch cdl) {
            this.i = i;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                System.out.println(i + "-th of go wait()");
                cdl.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i + "-th of go...");
        }
    }


}
