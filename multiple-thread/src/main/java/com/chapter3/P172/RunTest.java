package com.chapter3.P172;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class RunTest {

    public static void main(String[] args) {
        try {
//            WriteData writeData = new WriteData();
//            ReadData readData = new ReadData();

            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();

            in.connect(out);
            //out.connect(i new ThreadRead(readData, inputStream);
            ////            threadRead.start();
            ////            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            ////            threadWrite.start();
            //
            //            // 读线程
            //            new Thread(() -> n);

            new Thread(() -> {
                try {
                    Thread.sleep(10);
                    System.out.println("read: ");
                    byte[] byteArray = new byte[20];
                    int readLength = in.read(byteArray);
                    while (-1 != readLength) {
                        String newData = new String(byteArray, 0, readLength);
                        System.out.print(newData);
                        readLength = in.read(byteArray);
                    }
                    System.out.println();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            // 写线程
            new Thread(() -> {
                try {
                    System.out.println("write :");
                    for (int i = 0; i < 300; i++) {
                        String outData = "" + (i + 1);
                        out.write(outData.getBytes());
                        System.out.print(outData);
                    }
                    System.out.println();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
