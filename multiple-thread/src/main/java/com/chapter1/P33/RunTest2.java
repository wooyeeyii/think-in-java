package com.chapter1.P33;

public class RunTest2 {

    public static void main(String[] args) throws InterruptedException {
        Model model = new Model();
        MyThread2 thread = new MyThread2(model);
        thread.start();
        Thread.sleep(1000);
        thread.stop();
        System.out.println(String.format("username:%s, password:%s", model.getUsername(), model.getPassword()));
    }

}
