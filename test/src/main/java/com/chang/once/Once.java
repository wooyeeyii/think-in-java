package com.chang.once;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Once {

    public static void main(String[] args) throws IOException {
        AA a = new AA();
        a.setSelf(a);
        System.out.println(a.toString());
    }

}





