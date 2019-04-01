package com.distributed.lock.redis;

public class RedisLock {

    private RedisUtil redisUtil = RedisUtil.getInstance();

    /**
     * @param lockKey 锁key
     * @param expires 过期时间 单位 mm
     * @return
     */
    public boolean getDistributedLock(String lockKey, long expires) {
        //客户端标识 在释放锁时 确保由设置锁的客户端来释放自己的锁
        String expiresStr = String.valueOf(expires + System.currentTimeMillis());

        // 如果当前锁不存在，返回加锁成功
        if (redisUtil.setnx(lockKey, expiresStr) == 1L) {
            return true;
        }

        // 如果锁存在，获取锁的过期时间
        String currentValue = redisUtil.get(lockKey);
        String currentValueStr = null == currentValue ? null : currentValue;
        // 判断当前锁是否过期
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间 此处多个客户端会覆盖锁的过期时间
            String oldValue = redisUtil.getset(lockKey, String.valueOf(expires + System.currentTimeMillis()));
            String oldValueStr = null == oldValue ? null : oldValue;
            // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                return true;
            }
        }
        // 其他情况，一律返回加锁失败
        return false;
    }

    /**
     * @param lockKey 锁key
     * @return
     */
    public boolean releaseDistributedLock(String lockKey) {
        String currentValue = redisUtil.get(lockKey);
        String currentValueStr = null == currentValue ? null : currentValue;
        // 判断当前锁是否过期
        if (currentValueStr != null && Long.parseLong(currentValueStr) > System.currentTimeMillis()) {
            redisUtil.del(lockKey);
            return true;
        }
        return false;
    }

}
