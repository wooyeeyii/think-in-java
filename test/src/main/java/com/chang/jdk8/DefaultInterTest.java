package com.chang.jdk8;

public class DefaultInterTest {

    public static void main(String[] args) {
        DefaultInter in = new DefaultInterImpl();
        System.out.println(in.getName());
        System.out.println("------------------");
        in.eat("fan");
        System.out.println("------------------");
        DefaultInter.staticMethod();
        System.out.println("------------------");
        DefaultInterImpl.staticMethod();
        System.out.println("------------------");
    }
}
