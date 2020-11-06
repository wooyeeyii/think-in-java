package com.chapter1.P24;

public class RunTest {

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(() -> {
                for (int i = 0; i <= 50000; i++) {
                    System.out.println("i = " + i);
                }
            });

            thread.start();

            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch.");
            e.printStackTrace();
        }
    }

}
