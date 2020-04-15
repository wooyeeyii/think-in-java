package com.chapter1.P38;

public class RunTest3 {

    public static void main(String[] args) throws InterruptedException {
        final MyObject model = new MyObject();
        Thread thread = new Thread() {
            @Override
            public void run() {
                model.setValue("a", "aa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(1000);

        model.printInfo();
    }

}
