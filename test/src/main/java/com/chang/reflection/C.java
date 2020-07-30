package com.chang.reflection;

public class C {
    private int c;

    static {
        System.out.println("--- C  静态的参数初始化 ---");
    }

    {
        System.out.println("--- C 非静态的参数初始化 ---");
    }
}
