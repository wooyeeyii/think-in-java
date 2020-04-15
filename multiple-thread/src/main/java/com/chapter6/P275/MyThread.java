package com.chapter6.P275;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(MyObject.getInstance().hashCode());
    }
}
