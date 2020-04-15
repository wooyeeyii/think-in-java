package com.tomcat.chapter3;


import com.tomcat.chapter3.connector.http.HttpRequest;
import com.tomcat.chapter3.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
