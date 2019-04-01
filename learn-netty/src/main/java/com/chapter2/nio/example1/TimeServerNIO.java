package com.chapter2.nio.example1;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeServerNIO {

    int port = 10111;
    protected static int BUFF_SIZE = 1024;
    private boolean stop;
    protected Selector selector = null;

    public void start() {
        ServerSocketChannel acceptorSvr = null;
        try {
            acceptorSvr = ServerSocketChannel.open();
            acceptorSvr.configureBlocking(false);
            acceptorSvr.bind(new InetSocketAddress(port));
            selector = Selector.open();
            acceptorSvr.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("TimeserverNIO start...");

            SelectionKey key = null;
            while (!stop) {
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    try {
                        handleEvent(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                    iterator.remove();
                }
            }

            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    protected void handleEvent(SelectionKey key) throws IOException {
        if (key.isValid()) {
            /** 处理新接入的请求消息 **/
            if (key.isAcceptable()) {
                dealWithAccept(key);
            }

            /** 处理有读事件的消息 **/
            if (key.isReadable()) {
                dealWithRead(key);
            }
        }
    }

    private void dealWithAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
    }

    private void dealWithRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(BUFF_SIZE);
        int readBytes = sc.read(readBuffer);
        if (readBytes > 0) {
            readBuffer.flip();
            byte[] bytes = new byte[readBuffer.remaining()];
            readBuffer.get(bytes);
            String body = new String(bytes, "UTF-8");
            System.out.println("TimeserverNIO receive data:" + body);
            doWrite(sc, "TimeserverNIO receive data:" + body);
        } else if (readBytes < 0) {
            // 对端链路关闭
            key.cancel();
            sc.close();
        }
    }

    protected void doWrite(SocketChannel sc, String response) throws IOException {
        if (StringUtils.isNotBlank(response)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFF_SIZE);
            byteBuffer.put(response.getBytes());
            byteBuffer.flip();
            sc.write(byteBuffer);
            System.out.println("send to client:" + response);
        }
    }

    public void stop() {
        this.stop = true;
    }

    public static void main(String[] args) {
        new TimeServerNIO().start();
    }
}

