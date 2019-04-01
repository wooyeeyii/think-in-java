package com.chapter5;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler extends ChannelHandlerAdapter {

    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String body = (String) msg;
//        System.out.println("This is " + ++counter + " times receive client : [" + body + "]");
//        body += "$_";
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(echo);

        System.out.println("Receive client: [" + msg + "]");
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
