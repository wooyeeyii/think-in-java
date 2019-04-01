package com.chang.common;

import org.junit.Test;

public class RedisUtilTest {

    private RedisUtil redisUtil = RedisUtil.getInstance();

    @Test
    public void method1() {
        System.out.println(redisUtil == null);
//        redisUtil.setex("chang", "junjie", 1);
        redisUtil.setnx("chang", "10");
        System.out.println(redisUtil.get("chang"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(redisUtil.get("chang"));
    }

}