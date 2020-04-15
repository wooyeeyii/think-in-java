package com.chapter4.P222;

public class hasQueuedThreadTest {

    public static void main(String[] args) throws InterruptedException {
        final MyService myService = new MyService();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.start();
        Thread.sleep(500);

        System.out.println(myService.lock.hasQueuedThread(threadA));
        System.out.println(myService.lock.hasQueuedThread(threadB));
        System.out.println(myService.lock.hasQueuedThreads());
    }

}
