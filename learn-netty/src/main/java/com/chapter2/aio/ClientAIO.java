package com.chapter2.aio;

public class ClientAIO {

    public static void main(String[] args) {

        AsyncTimeClientHandler client = new AsyncTimeClientHandler();
        client.start();
    }
}
