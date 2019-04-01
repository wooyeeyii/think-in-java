package com.tomcat.chapter15.digestertest;

import org.apache.commons.digester.Digester;

import java.io.File;

public class Test03 {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator +
                "/my-tomcat/src/main/resources/chapter15";
        File file = new File(path, "employee2.xml");
        Digester digester = new Digester();
        digester.addRuleSet(new EmployeeRuleSet());

        Test02.parseAndTest(digester, file);
    }
}
  
