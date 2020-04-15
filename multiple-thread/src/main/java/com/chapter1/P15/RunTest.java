package com.chapter1.P15;

public class RunTest {

    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread a = new Thread(run);
        Thread b = new Thread(run);
        Thread c = new Thread(run);
        Thread d = new Thread(run);
        Thread e = new Thread(run);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

}
