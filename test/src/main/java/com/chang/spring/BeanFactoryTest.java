package com.chang.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {

    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Test1 test1 = (Test1) bf.getBean("test1");
        test1.method();
//        Test2 test2 = (Test2)bf.getBean("test2");
//        test2.method();
    }
}
