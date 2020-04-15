package com.chapter1.P9;

public class RunTest1 {

    public static void main(String[] args) {
        ThreadWithPrivateData a = new ThreadWithPrivateData("A");
        ThreadWithPrivateData b = new ThreadWithPrivateData("B");
        ThreadWithPrivateData c = new ThreadWithPrivateData("C");

        a.start();
        b.start();
        c.start();
    }

}
