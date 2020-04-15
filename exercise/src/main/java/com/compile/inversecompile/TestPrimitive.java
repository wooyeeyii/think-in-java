package com.compile.inversecompile;

public class TestPrimitive {

    public static void main(String[] args) {
        Process process = new Process();
        int age = 18;

        System.out.println("before function:" + age);
        process.function3(age);
        System.out.println("after function:" + age);
    }

}
