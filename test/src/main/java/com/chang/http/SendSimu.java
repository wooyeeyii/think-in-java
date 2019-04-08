package com.chang.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SendSimu {

    public String sendGet(String url) {
        String response = null;
        System.out.println("url: " + url);
        try {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse httpResponse = null;
            try {
                httpClient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
//                response = EntityUtils.toString(httpResponse.getEntity());
//                System.out.println("response: " + response);
                int code = httpResponse.getStatusLine().getStatusCode();
                System.out.println(200 == code);
            } finally {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //post请求方法
    public String sendPost(String url, String data) {
        String response = null;
        System.out.println("url: " + url);
        System.out.println("request: " + data);
        try {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse httpResponse = null;
            try {
                httpClient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("text/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpResponse = httpClient.execute(httppost);
                response = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("response: " + response);
            } finally {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static void main(String[] args) {
        SendSimu sendSimu = new SendSimu();
        sendSimu.sendGet("http://www.baidu.com");
    }


}