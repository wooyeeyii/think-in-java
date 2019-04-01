package com.protocol.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class ChineseProverbClient {

    public void run(int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbClientHandler());
            Channel ch = b.bind(0).sync().channel();
            // 无需等待建立连接，直接发送
            // 向网段内的所有机器广播UDP消息
            Object datagramPackage = new DatagramPacket(
                    Unpooled.copiedBuffer("谚语字典查询?", CharsetUtil.UTF_8),
                    new InetSocketAddress("255.255.255.255", port));
            ch.writeAndFlush(datagramPackage).sync();
            if (!ch.closeFuture().await(15000)) {
                System.out.println("查询超时!");
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8876;
        new ChineseProverbClient().run(port);
    }
}
