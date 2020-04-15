package com.chapter6.P264;

public class MyObject {
    //立即加载方式==饿汉模式
    private static MyObject myObject = null;

    private MyObject() {
    }

    public static MyObject getInstance() {
        //延迟加载
        if (null == myObject) {
            myObject = new MyObject();
        }
        return myObject;
    }

}
