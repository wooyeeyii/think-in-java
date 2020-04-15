package com.chapter3.P184;

/**
 * 使用sleep等待线程结束
 *
 * @author junjie.chang
 */
public class ThreadA extends Thread {

    private ThreadB b;

    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                Thread.sleep(6000);    //不释放锁
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
