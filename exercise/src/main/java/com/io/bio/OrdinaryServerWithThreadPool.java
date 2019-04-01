/**
 * 使用线程池来处理同时多个socket请求的伪异步IO
 */
package com.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class OrdinaryServerWithThreadPool {

    public void start() {
        //创建一个线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建socket服务,打开并监听8888端口
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8888);
            while (true) {
                //获取一个套接字（阻塞）
                socket = server.accept();
                System.out.println("来个一个新客户！");
                SocketHandler handler = new SocketHandler(socket);
                //派送空闲的前台妹子去接待客人
                newCachedThreadPool.execute(handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        OrdinaryServerWithThreadPool server = new OrdinaryServerWithThreadPool();
        server.start();
    }
}
