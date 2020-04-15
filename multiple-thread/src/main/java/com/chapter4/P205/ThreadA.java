package com.chapter4.P205;

public class ThreadA extends Thread {

    private MyService myService;

    public ThreadA(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        myService.await();
    }

}
