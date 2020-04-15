package com.chapter4.P224;

public class isHeldByCurrentThreadTest {

    public static void main(String[] args) {
        final MyService myService = new MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.isHeldByCurrentThreadMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
