package com.chang.reflection;

public class A {
    private int a;

    static {
        System.out.println("--- A  静态的参数初始化 ---");
    }

    {
        System.out.println("--- A 非静态的参数初始化 ---");
    }
}
