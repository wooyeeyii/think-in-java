package com.tomcat.chapter3.startup;

import com.tomcat.chapter3.connector.http.HttpConnector;

/**
 * 这个程序在运行时，需要将LocalStrings.properties等文件拷贝到target对应的位置下
 */
public final class Bootstrap {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        System.out.println("bootstrap begin...");
        connector.start();
    }
}
