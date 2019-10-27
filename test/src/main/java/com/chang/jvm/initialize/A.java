package com.chang.jvm.initialize;

public class A {
    public static int a = mentod();
    public static int b = 2;

    static {
        System.out.println("AA.static block");
        b = 2;
    }

    public A() {
        System.out.println("AA constructor");
    }

    private static int mentod() {
        System.out.println("AA.static value");
        return 1;
    }
}
