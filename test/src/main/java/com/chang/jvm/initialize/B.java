package com.chang.jvm.initialize;

public class B extends A {
    public static int c = mentod();
    public static int d = 2;

    static {
        System.out.println("B.static block");
        d = 2;
    }

    public B() {
        System.out.println("B constructor");
    }

    private static int mentod() {
        System.out.println("B.static value");
        return 1;
    }
}
