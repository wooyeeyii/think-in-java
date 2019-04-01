package com.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class OrdinaryServer {

    public static void main(String[] args) throws Exception {
        //创建socket服务,打开并监听8888端口
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            while (true) {
                //获取一个套接字（阻塞）
                final Socket socket = server.accept();
                System.out.println("来个一个新客户！");
                //前台妹子给客人端茶倒水
                handler(socket);
            }
        } finally {
            server.close();
        }
    }

    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            //获取socket的一个输入流
            InputStream inputStream = socket.getInputStream();
            while (true) {
                //循环读取读取数据（阻塞）
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }

            Thread.sleep(3000);

            //写入返回信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
            pw.write("服务器收到消息.");
            pw.flush();
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}