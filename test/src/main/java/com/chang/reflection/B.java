package com.chang.reflection;

public class B {
    private int b;

    static {
        System.out.println("--- B  静态的参数初始化 ---");
    }

    {
        System.out.println("--- B 非静态的参数初始化 ---");
    }
}
