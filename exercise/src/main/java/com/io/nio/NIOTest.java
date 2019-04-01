package com.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NIOTest {

    public void start() {
        try {
            //创建ServerSocketChannel通道，绑定监听端口为8080
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8888));
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //注册选择器,设置选择器选择的操作类型
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //创建处理器
            NIOHandler handler = new NIOHandler(1024);
            while (true) {
                //等待请求，每次等待阻塞3s，超过时间则向下执行，若传入0或不传值，则在接收到请求前一直阻塞
                if (selector.select(3000) == 0) {
                    System.out.println("等待请求超时......");
                    continue;
                }
                System.out.println("-----处理请求-----");
                //获取待处理的选择键集合
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    try {
                        //如果是连接请求，调用处理器的连接处理方法
                        if (selectionKey.isAcceptable()) {
                            handler.handleAccept(selectionKey);
                        }
                        //如果是读请求，调用对应的读方法
                        if (selectionKey.isReadable()) {
                            handler.handleRead(selectionKey);
                        }
                    } catch (IOException e) {
                        keyIterator.remove();
                        continue;
                    }
                }
                //处理完毕从待处理集合移除该选择键
                keyIterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NIOTest test = new NIOTest();
        test.start();
    }

}
