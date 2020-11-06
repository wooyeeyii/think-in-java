package com.chang.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 {

    private Test1 test1;

    @Autowired
    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public void method() {
        System.out.println("test2");
    }

}
