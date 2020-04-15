package com.chapter4.P200;

public class MyThread extends Thread {

    private MyService myService;

    public MyThread(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        myService.testMethod();
    }

}
