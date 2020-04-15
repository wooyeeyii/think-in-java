package com.chapter1.P13;

public class LoginServlet {

    private static String username;
    private static String password;

    public static void doPost(String name, String word) {
        try {
            username = name;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            password = word;
            System.out.println(String.format("username = %s, password = %s.", username, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
