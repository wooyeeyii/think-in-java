package com.chapter1.P33;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            this.stop();
        } catch (ThreadDeath e) {
            // TODO Auto-generated catch block
            System.out.println("stop() 之后进入catch() 方法。");
            e.printStackTrace();
        }
    }

}
