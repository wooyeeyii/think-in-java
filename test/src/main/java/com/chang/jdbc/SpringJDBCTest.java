package com.chang.jdbc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTest {
    public static void main(String[] args) {

        BeanFactory bf = new ClassPathXmlApplicationContext("jdbc.xml");
        UserService userService = (UserService) bf.getBean("userService");
        User user = new User(1, "chang", 2);
        userService.save(user);
        List<User> list = userService.getUsers();
        for (User a : list) {
            System.out.println(a.toString());
        }
    }
}
