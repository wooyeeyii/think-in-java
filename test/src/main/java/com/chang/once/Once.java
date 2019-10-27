package com.chang.once;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Once {

    public static void main(String[] args) throws IOException {

        String emailRegex = "^[a-zA-z0-9]{1,30}@[a-zA-Z0-9]{1,30}\\.[a-z]{1,10}";
        System.out.println("wo@13.com".matches(emailRegex));

    }



}



