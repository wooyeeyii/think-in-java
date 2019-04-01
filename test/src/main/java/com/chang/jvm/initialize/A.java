package com.chang.jvm.initialize;

public class A {
    public static int a = mentod();
    public static int b = 2;

    static {
        System.out.println("A.static block");
        b = 2;
    }

    public A() {
        System.out.println("A constructor");
    }

    private static int mentod() {
        System.out.println("A.static value");
        return 1;
    }
}
