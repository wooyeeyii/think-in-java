package com.chapter3.extend;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        cyclicBarrierTest.methodTest();
    }

    public void methodTest() {
        int count = 5;
        final CyclicBarrier cb = new CyclicBarrier(count);
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,
                60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(count));

        for (int i = 0; i < count; i++) {
            pool.execute(new MyRunnable(i, cb));
        }

        pool.shutdown();
    }

    class MyRunnable implements Runnable {
        int i;
        CyclicBarrier cb;

        public MyRunnable(int i, CyclicBarrier cb) {
            this.i = i;
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.println(i + "-th wait...");
            try {
                cb.await();
                System.out.println(i + "-th go...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}
