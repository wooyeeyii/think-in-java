package com.chapter1.P13;

public class RunTest {

    public static void main(String[] args) {
        LoginServlet loginServlet = new LoginServlet();
        Thread a = new Thread(() ->
                loginServlet.doPost("a", "aa")
        );
        a.start();

        Thread b = new Thread(() ->
                loginServlet.doPost("b", "bb")
        );
        b.start();
    }

}
