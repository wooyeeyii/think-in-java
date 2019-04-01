package com.io.nio.example;

import com.io.nio.IMessageProcessor;
import com.io.nio.Message;
import com.io.nio.Server;
import com.io.nio.WriteProxy;
import com.io.nio.http.HttpMessageReaderFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                "Content-Length: 38\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body>Hello World!</body></html>";

        final byte[] httpResponseBytes = httpResponse.getBytes("UTF-8");

        IMessageProcessor messageProcessor = new IMessageProcessor() {
            @Override
            public void process(Message request, WriteProxy writeProxy) {
                System.out.println("Message Received from socket: " + request.socketId);

                Message response = writeProxy.getMessage();
                response.socketId = request.socketId;
                response.writeToMessage(httpResponseBytes);

                writeProxy.enqueue(response);
            }
        };

        Server server = new Server(9999, new HttpMessageReaderFactory(), messageProcessor);

        server.start();

    }


}
