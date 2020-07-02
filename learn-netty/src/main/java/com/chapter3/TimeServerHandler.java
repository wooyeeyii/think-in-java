package com.chapter3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Date;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /*@Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channelActive...");
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time);
        // code below equals
        // f.addListener(ChannelFutureListener.CLOSE);
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                System.out.println("channel closing...");
                ctx.close();
            }
        });
        ctx.fireChannelActive();
    }*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        String body = in.toString(CharsetUtil.UTF_8);
        System.out.println("The server receive message:" + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                new Date().toString() : "BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
