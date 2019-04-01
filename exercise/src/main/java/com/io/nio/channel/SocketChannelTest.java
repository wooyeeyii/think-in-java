package com.io.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {

    public void read() {
        SocketChannel socketChannel = null;
        ByteBuffer buf = ByteBuffer.allocate(1024);
        RandomAccessFile aFile = null;
        FileChannel writeChannel = null;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));
            aFile = new RandomAccessFile("exercise/src/main/java/resources/nio-channel-output.txt", "rw");
            writeChannel = aFile.getChannel();

            int bytesRead = socketChannel.read(buf);
            buf.flip();
            while(buf.hasRemaining()) {
                writeChannel.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                aFile.close();
                socketChannel.close();
                writeChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SocketChannelTest test = new SocketChannelTest();
        test.read();
    }


}
