package com.chang.spring.context;

import com.chang.spring.bean.Test1;
import com.chang.spring.bean.Test2;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class XmlApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Test1 test1 = (Test1) bf.getBean("test1");
        test1.method();
        System.out.println("##########################");

        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("applicationContext1.xml");
        context.refresh();
        Test2 test2 = (Test2) context.getBean("test2");
        test2.method();
        System.out.println("##########################");
    }
}
