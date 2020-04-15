package com.chapter1.P28;

public class MyThread2 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了！即将退出!");
                    throw new InterruptedException();
                }
                //System.out.println("i = " + i);
            }
            //
            System.out.println("last statement in MyThread.run()");
        } catch (InterruptedException e) {
            System.out.println("进入MyThread.run()方法中的catch. ");
            e.printStackTrace();
        }
    }

}
