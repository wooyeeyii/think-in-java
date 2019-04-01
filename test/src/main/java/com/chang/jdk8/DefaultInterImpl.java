package com.chang.jdk8;

public class DefaultInterImpl implements DefaultInter {
    @Override
    public String getName() {
        return "name";
    }

    public static void staticMethod() {
        System.out.println("123");
    }

    // 重写方法，调用接口中的默认函数
    @Override
    public void eat(String thing) {
        System.out.println("invoke default method");
        DefaultInter.super.eat(thing);
        System.out.println("DefaultInterImpl");
    }
}
