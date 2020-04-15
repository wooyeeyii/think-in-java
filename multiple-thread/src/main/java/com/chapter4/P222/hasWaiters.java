package com.chapter4.P222;

public class hasWaiters {

    public static void main(String[] args) throws InterruptedException {
        final MyService myService = new MyService();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.conditionWatiMehod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        //按顺序启动运行
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

        Thread.sleep(2000);
        myService.notityMehtod();
    }

}
