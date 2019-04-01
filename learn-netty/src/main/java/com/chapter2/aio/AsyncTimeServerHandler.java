package com.chapter2.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

    private int port;
    CountDownLatch latch = null;
    AsynchronousServerSocketChannel asynServerSocketChannel = null;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            asynServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("server start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        asynServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
