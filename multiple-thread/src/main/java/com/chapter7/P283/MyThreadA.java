package com.chapter7.P283;

public class MyThreadA extends Thread {

    @Override
    public void run() {
        MyService.serviceMethod();
    }

}
