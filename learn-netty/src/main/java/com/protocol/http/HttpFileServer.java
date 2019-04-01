package com.protocol.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

    private String host;
    private String url;
    private int port;

    public HttpFileServer(String host, int port, String url) {
        this.host = host;
        this.url = url;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChildChanelHandler());
            ChannelFuture future = b.bind(host, port).sync();
            System.out.println("HTTP文件目录服务器启动，网址是 : " + "http://" + host + ":" + port + url);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChanelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            /** *** **/
            // HTTP请求消息解码器
            ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
            // 目的是将多个消息转换为单一的FullHttpRequest或者FullHttpResponse对象
            // 因为上一步的解码器(HTTP解码器)在每个HTTP消息中会生成多个消息对象(HttpRequest/HttpResponse, HttpContent, LastHttpContent)
            ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
            // HTTP响应解码器
            ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
            // 目的是支持异步发送大的码流(大文件的传输)， 但不占用过多内存，防止java内存溢出错误
            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());

            /** 业务逻辑 **/
            ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
        }
    }

    public static void main(String[] args) throws Exception {
        String host = "10.45.0.137";  //若使用127.0.0.1，则其他机器是无法访问的
        int port = 8998;
//        String url = "/learn-netty/src/main/java/com/";
        String url = "/";
        HttpFileServer server = new HttpFileServer(host, port, url);
        server.run();
    }
}
