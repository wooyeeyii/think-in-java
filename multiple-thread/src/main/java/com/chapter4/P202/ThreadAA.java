package com.chapter4.P202;

public class ThreadAA extends Thread {

    private MyService myService;

    public ThreadAA(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        myService.methodA();
    }

}
