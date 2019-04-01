package com.chang.jdk8;

public interface DefaultInter {

    String a = "1234567890";    //变量不能是privat类型

    String getName();

    static void staticMethod() {
        System.out.println("this is a static method in interface.");
        System.out.println(a);
    }

    default void eat(String thing) {
        System.out.println("eat " + thing);
    }
}
