package com.chapter1.P50;

public class RunTest1 {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setDaemon(true);    //将thread设置为main的守护线程
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我离开了，thread对象也不再打印了，也就是停止了");
    }

}
