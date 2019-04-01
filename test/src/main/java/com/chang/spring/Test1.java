package com.chang.spring;

public class Test1 {

    private Test2 test2;

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }

    public void method() {
        System.out.println("test1");
        test2.method();
    }
}
