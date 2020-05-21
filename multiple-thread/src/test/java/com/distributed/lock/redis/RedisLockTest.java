package com.distributed.lock.redis;

import org.junit.Assert;
import org.junit.Test;

public class RedisLockTest {

    @Test
    public void test1() {
        ThreadA threadA = new ThreadA();
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(threadA, "Thread-" + i);
            a.start();
        }

        //等待足够的时间，避免测试用例跑完而线程未执行完而直接退出的情形
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals((Long) 10L, threadA.getValue());
    }
}