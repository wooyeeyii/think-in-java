package com.io.bio;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    public void run() {
        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //创建客户端Socket，指定服务器地址和端口
            socket = new Socket("localhost", 8888);

            //获取输出流，向服务器端发送信息
            os = socket.getOutputStream();//字节输出流
            pw = new PrintWriter(os);//将输出流包装成打印流
            pw.write("message send to server.");
            pw.flush();
            socket.shutdownOutput();

            //获取输入流，并读取服务器端的响应信息
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("服务器返回信息：" + info);
            }
            System.out.println("读取完毕.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                pw.close();
                br.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Client());
            thread.start();
        }
    }

}
