package com.chang.spring;

import org.springframework.stereotype.Component;

@Component
public class Test2 {

    private Test1 test1;

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public void method() {
        System.out.println("test2");
    }

}
