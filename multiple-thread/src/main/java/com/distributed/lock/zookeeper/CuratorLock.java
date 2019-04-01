package com.distributed.lock.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 基于zookeeper的开源客户端Cruator实现分布式锁
 */
public class CuratorLock {
    public static Logger log = LoggerFactory.getLogger(CuratorLock.class);
    private InterProcessMutex interProcessMutex;  //可重入排它锁
    private String lockName;  //竞争资源标志
    private String root = "/distributed/lock/";//根节点
    private static CuratorFramework curatorFramework;
    private static String ZK_URL = "127.0.0.1:2181";

    static {
        curatorFramework = CuratorFrameworkFactory.newClient(ZK_URL, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
    }

    /**
     * 实例化
     *
     * @param lockName
     */
    public CuratorLock(String lockName) {
        try {
            this.lockName = lockName;
            interProcessMutex = new InterProcessMutex(curatorFramework, root + lockName);
        } catch (Exception e) {
            log.error("initial InterProcessMutex exception=" + e);
        }
    }

    /**
     * 获取锁
     */
    public void acquireLock() {
        int flag = 0;
        try {
            //重试2次，每次最大等待2s，也就是最大等待4s
            while (!interProcessMutex.acquire(2, TimeUnit.SECONDS)) {
                flag++;
                if (flag > 1) {  //重试两次
                    break;
                }
            }
        } catch (Exception e) {
            log.error("distributed lock acquire exception=" + e);
        }
        if (flag > 1) {
            log.info("Thread:" + Thread.currentThread().getId() + " acquire distributed lock  busy");
        } else {
            log.info("Thread:" + Thread.currentThread().getId() + " acquire distributed lock  success");
        }
    }

    /**
     * 释放锁
     */
    public void releaseLock() {
        try {
            if (interProcessMutex != null && interProcessMutex.isAcquiredInThisProcess()) {
                interProcessMutex.release();
                curatorFramework.delete().inBackground().forPath(root + lockName);
                log.info("Thread:" + Thread.currentThread().getId() + " release distributed lock  success");
            }
        } catch (Exception e) {
            log.info("Thread:" + Thread.currentThread().getId() + " release distributed lock  exception=" + e);
        }
    }
}
