package com.chapter1.P33;

import lombok.Data;

@Data
public class Model {

    private String username = "a";

    private String password = "aa";

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(10000000);
            this.password = password;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
