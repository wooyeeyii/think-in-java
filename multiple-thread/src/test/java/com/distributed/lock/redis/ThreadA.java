package com.distributed.lock.redis;

public class ThreadA extends Thread {

    RedisLock redisLock = new RedisLock();

    private final String uniqueKey = "lockKey";
    private final Long expireTime = 10000L;

    private Long val = 0L;

    public ThreadA() {
    }

    @Override
    public void run() {
        while(!redisLock.getDistributedLock(uniqueKey, expireTime)) {
        }
        val++;
        System.out.println(val);
        redisLock.releaseDistributedLock(uniqueKey);
    }

    public Long getValue() {
        return val;
    }
}
