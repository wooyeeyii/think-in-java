package com.tomcat.chapter16.shutdownhook;

public class ShotDownHookDemo {

    public void start() {
        System.out.println("Demo");
        ShutDownHook shutDownHook = new ShutDownHook();
        Runtime.getRuntime().addShutdownHook(shutDownHook);
    }

    public static void main(String[] args) {
        ShotDownHookDemo demo = new ShotDownHookDemo();
        demo.start();
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ShutDownHook extends Thread {
        @Override
        public void run() {
            System.out.println("Shutting down.");
        }
    }
}
