package com.chang.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircleConstructDeTest {

    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Test4 test4 = (Test4) bf.getBean("test4");
        test4.method();
    }
}
