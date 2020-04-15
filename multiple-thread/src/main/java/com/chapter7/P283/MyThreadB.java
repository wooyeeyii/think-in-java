package com.chapter7.P283;

public class MyThreadB extends Thread {

    @Override
    public void run() {
        MyService.serviceMethod();
    }

}
