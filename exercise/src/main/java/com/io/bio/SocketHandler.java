package com.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
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
