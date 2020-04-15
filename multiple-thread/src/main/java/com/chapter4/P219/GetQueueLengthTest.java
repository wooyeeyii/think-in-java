package com.chapter4.P219;

public class GetQueueLengthTest {

    public static void main(String[] args) throws InterruptedException {
        int number = 10;
        final MyService myService = new MyService();
        Thread[] thread = new Thread[number];
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.getQueueLengthMethod1();
            }
        };

        for (int i = 0; i < number; i++) {
            thread[i] = new Thread(runnable);
        }
        for (int i = 0; i < number; i++) {
            thread[i].start();
        }
        Thread.sleep(2000);

        System.out.println("有线程数：" + myService.lock.getQueueLength() + " 在等待获得锁！");
    }


}
