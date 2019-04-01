package com.io.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public void copy(String sourcePath, String destPath) {
        RandomAccessFile aFile = null;
        FileChannel inChannel = null;
        RandomAccessFile bFile = null;
        FileChannel outChannel = null;

        try {
            aFile = new RandomAccessFile(sourcePath, "rw");
            inChannel = aFile.getChannel();
            inChannel.position(7);  // 正常0 3      乱码：1，2，4， 5， 6
            bFile = new RandomAccessFile(destPath, "rw");
            outChannel = bFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (-1 != inChannel.read(buf)) {
                buf.flip();
                while (buf.hasRemaining()) {
                    outChannel.write(buf);
                }
                buf.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                aFile.close();
                bFile.close();
                inChannel.close();
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileChannelTest test = new FileChannelTest();
        try {
            test.copy("exercise/src/main/java/resources/nio-in.txt",
                    "exercise/src/main/java/resources/nio-out.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
