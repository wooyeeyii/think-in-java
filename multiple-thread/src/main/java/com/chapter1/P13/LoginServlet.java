package com.chapter1.P13;

public class LoginServlet {
    private String username;
    private String password;

    public void doPost(String name, String word) {
        try {
            username = name;
            if (username.equals("a")) {
                Thread.sleep(100);
            }

            password = word;
            System.out.println(String.format("username = %s, password = %s.",
                    username, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
