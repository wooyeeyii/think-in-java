package com.tomcat.chapter2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "my-tomcat" +
            File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer1 server = new HttpServer1();
        System.out.println(WEB_ROOT);
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8899);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //loop waiting for a request
        while (!shutdown) {
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                socket = serverSocket.accept();
                System.out.println("接入一个新的客户端...");
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                // create Request object and parse
                Request request = new Request(inputStream);
                request.parse();

                //create Response object
                Response response = new Response(outputStream);
                response.setRequest(request);

                //check if this is a request for servlet or a static resource
                // a request for a servlet begins with /servlet
                if (request.getUri().startsWith("/servlet")) {
                    ServletProcessor1 processor = new ServletProcessor1();
                    processor.process(request, response);
                } else {
                    StaticResourceProcessor processor = new StaticResourceProcessor();
                    processor.process(request, response);
                }

                //close socket;
                socket.close();

                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
