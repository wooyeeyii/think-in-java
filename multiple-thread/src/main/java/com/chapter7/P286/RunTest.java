package com.chapter7.P286;

public class RunTest {

    public static void main(String[] args) {
        //ThreadA aThreadTmp = new ThreadA();
        ThreadB bThreadTmp = new ThreadB();
        ThreadGroup group = new ThreadGroup("My Group");
        Thread aThread = new Thread(group, new ThreadA());
        Thread bThread = new Thread(group, bThreadTmp);
        aThread.start();
        bThread.start();
        //bThreadTmp.start();
        System.out.println("活动的线程数为：" + group.activeCount());
        System.out.println("线程组的名称为：" + group.getName());
    }

}
