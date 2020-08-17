package com.chang.once;

public class D {

    public void method1() {
        System.out.println("method1...");
        method2();
    }

    void method2() {
        System.out.println("method2 inside D...");
    }
}
