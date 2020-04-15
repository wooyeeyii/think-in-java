package com.chapter4.P202;

public class ThreadBB extends Thread {

    private MyService myService;

    public ThreadBB(MyService service) {
        this.myService = service;
    }

    @Override
    public void run() {
        myService.methodB();
    }

}
