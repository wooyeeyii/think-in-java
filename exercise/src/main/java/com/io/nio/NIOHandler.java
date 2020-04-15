package com.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NIOHandler {

    private int bufferSize = 1024;  //缓冲器容量
    private String localCharset = "UTF-8";  //编码格式

    String esponse = "HTTP/1.1 200 OK\r\n" +
            "Content-Length: 38\r\n" +
            "Content-Type: text/html\r\n" +
            "\r\n" +
            "<html><body>Hello World!</body></html>";

    public NIOHandler() {
    }

    public NIOHandler(int bufferSize) {
        this(bufferSize, null);
    }

    public NIOHandler(String localCharset) {
        this(-1, localCharset);
    }

    public NIOHandler(int bufferSize, String localCharset) {
        if (bufferSize > 0) {
            this.bufferSize = bufferSize;
        }
        if (localCharset != null) {
            this.localCharset = localCharset;
        }
    }

    /**
     * 连接请求处理方法
     */
    public void handleAccept(SelectionKey selectionKey) throws IOException {
        //通过选择器键获取服务器套接字通道，通过accept()方法获取套接字通道连接
        SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
        if (null != socketChannel) {
            //设置套接字通道为非阻塞模式
            socketChannel.configureBlocking(false);
            //为套接字通道注册选择器，该选择器为服务器套接字通道的选择器，即选择到该SocketChannel的选择器
            //设置选择器关心请求为读操作，设置数据读取的缓冲器容量为处理器初始化时候的缓冲器容量
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        } else {
            System.out.println("socketChannel is null.");
        }
    }

    public void handleRead(SelectionKey selectionKey) {
        //获取套接字通道
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) selectionKey.channel();
            // 获取缓冲器并进行重置,selectionKey.attachment()为获取选择器键的附加对象
            ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
            byteBuffer.clear();
            // 如果有内容
            if (socketChannel.read(byteBuffer) != -1) {
                // 将缓冲器转换为读状态
                byteBuffer.flip();
                // 将缓冲器中接收到的值按localCharset格式编码保存
                String receivedRequestData = Charset.forName(localCharset).newDecoder().decode(byteBuffer).toString();
                System.out.println("接收到客户端的请求数据：" + receivedRequestData);
                // 返回响应数据给客户端
//                String responseData = "已接收到你的请求数据，响应数据为：(响应数据)";
                byteBuffer = ByteBuffer.wrap(esponse.getBytes(localCharset));
                socketChannel.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭通道
            /*try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

}
