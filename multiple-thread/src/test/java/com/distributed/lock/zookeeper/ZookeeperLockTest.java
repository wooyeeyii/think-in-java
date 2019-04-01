package com.distributed.lock.zookeeper;

import java.util.concurrent.CountDownLatch;

public class ZookeeperLockTest {

    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        final CountDownLatch down = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            public void run() {
                ZookeeperLock lock = null;
                CuratorLock curatorLock = null;
                try {
                    down.await();
//                    lock = new ZookeeperLock("127.0.0.1:2181", "test1");
//                    lock.lock();

                    curatorLock = new CuratorLock("test2");
                    curatorLock.acquireLock();

                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    secskill();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                    if(curatorLock != null) {
                        curatorLock.releaseLock();
                    }
                }
            }
        };

        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }

        down.countDown();
    }

}