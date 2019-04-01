package com.tomcat.chapter15.digestertest;

import org.apache.commons.digester.Digester;

import java.io.File;

public class Test01 {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator +
                "/my-tomcat/src/main/resources/chapter15";
        File file = new File(path, "employee1.xml");
        Digester digester = new Digester();
        // add rules
        digester.addObjectCreate("employee", "com.tomcat.chapter15.digestertest.Employee");
        digester.addSetProperties("employee");
        digester.addCallMethod("employee", "printName");

        try {
            Employee employee = (Employee) digester.parse(file);
            System.out.println("First name : " + employee.getFirstName());
            System.out.println("Last name : " + employee.getLastName());
            employee.printName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
