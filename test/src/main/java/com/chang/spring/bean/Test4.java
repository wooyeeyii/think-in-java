package com.chang.spring.bean;

public class Test4 {

    private Test5 test5;

    public Test4(Test5 test5) {
        this.test5 = test5;
    }

    public void method() {
        System.out.println("test4");
        test5.method();
    }
}
