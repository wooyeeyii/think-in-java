package com.chang.spring.context;

import com.chang.spring.bean.ScanConfig;
import com.chang.spring.bean.Test1;
import com.chang.spring.bean.Test2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(Test1.class, Test2.class);
        Test1 test1 = (Test1) context1.getBean("test1");
        test1.method();


        System.out.println("########################################");
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        context2.register(Test1.class, Test2.class);
        context2.refresh();
        Test2 test2 = (Test2) context2.getBean("test2");
        test2.method();


        System.out.println("########################################");
        AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext();
        context3.register(ScanConfig.class);
        context3.refresh();
        test1 = (Test1) context3.getBean("test1");
        test1.method();
    }

}
