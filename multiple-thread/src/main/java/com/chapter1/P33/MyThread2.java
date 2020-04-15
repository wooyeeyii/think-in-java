package com.chapter1.P33;

public class MyThread2 extends Thread {

    private Model model;

    public MyThread2(Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        model.printString("b", "bb");
    }

}
