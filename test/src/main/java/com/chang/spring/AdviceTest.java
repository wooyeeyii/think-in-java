package com.chang.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {
    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext3.xml");
        // 使用CGlib可以这么用，使用接口的AOP这么用会报错，因为代理生成的类名为类似于sun.proxy.$Proxy2，只能通过接口调用
//        Test3 test3 = (Test3)bf.getBean("test3");
//        test3.method();

        Test3Interface test3Interface = (Test3Interface) bf.getBean("test3");
        test3Interface.method();
    }
}
