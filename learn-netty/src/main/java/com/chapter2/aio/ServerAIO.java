package com.chapter2.aio;

public class ServerAIO {

    public static void main(String[] args) {
        int port = 12222;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer).start();
    }


}
