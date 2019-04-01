package com.chang.spring;

public class AdviceSample {

    public void before() {
        System.out.println("before...");
    }

    public void after() {
        System.out.println("after...");
    }

    public void around() {
        System.out.println("around...");
    }
}
