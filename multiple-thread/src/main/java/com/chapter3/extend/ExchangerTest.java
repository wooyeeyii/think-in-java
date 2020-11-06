package com.chapter3.extend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 假设两个线程，它们都有一个队列，分别在它们各自的队列中，然后线程交换队列打印队列数据
 *
 * @author junjie.chang
 */

public class ExchangerTest {

    public static void main(String[] args) {
        ExchangerTest exchangerTest = new ExchangerTest();
        exchangerTest.methodTest();
    }

    public void methodTest() {
        final Exchanger<List> ex = new Exchanger<List>();
        Thread thread1 = new Thread(new MyRunnable1(ex));
        Thread thread2 = new Thread(new MyRunnable2(ex));

        thread1.start();
        thread2.start();

    }

    class MyRunnable1 implements Runnable {
        Exchanger<List> ex;

        public MyRunnable1(Exchanger<List> ex) {
            this.ex = ex;
        }

        @Override
        public void run() {
            List<String> list = new ArrayList<String>(Arrays.asList("thread1.item1", "thread1.item2"));
            try {
                System.out.println("thread1: before exchange");
                Thread.sleep(1000);
                list = ex.exchange(list);
                System.out.println("thread1: after exchange");
                System.out.println(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyRunnable2 implements Runnable {
        Exchanger<List> ex;

        public MyRunnable2(Exchanger<List> ex) {
            this.ex = ex;
        }

        @Override
        public void run() {
            List<String> list = new ArrayList<String>(Arrays.asList("thread2.item1", "thread2.item2"));
            try {
                System.out.println("thread2: before exchange");
                list = ex.exchange(list);
                System.out.println("thread2: after exchange");
                System.out.println(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
