package com.chang.http.breakpoint.resume;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private String fileName = ".\\test\\src\\main\\resources\\test.png";

    public static void main(String[] args) throws Exception {
        Client client = new Client();


        URL url = new URL("http://127.0.0.1:10012/download");
        InputStream input = client.getFileSegment(url);
        client.saveFile(input);

        Long beginIdx = 2048L;
        InputStream input2 = client.getFileSegmentBreak(beginIdx, url);
        client.saveFileAtSomePoint(beginIdx, input2);
    }

    private InputStream getFileSegment(URL url) throws Exception {
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        // 设置 User-Agent
        httpConnection.setRequestProperty("User-Agent", "NetFox");
        // 获得输入流
        InputStream input = httpConnection.getInputStream();
        return input;
    }

    private void saveFile(InputStream input) throws Exception {
        byte[] bs = new byte[1024];
        OutputStream os = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            os = new FileOutputStream(fileName);
            int len;
            // 开始读取
            while ((len = input.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } finally {
            if (null != os) {
                os.close();
            }
            if (null != input) {
                input.close();
            }
        }
    }

    private InputStream getFileSegmentBreak(Long start, URL url) throws Exception {
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        // 设置 User-Agent
        httpConnection.setRequestProperty("User-Agent", "NetFox");
        // 设置断点续传的开始位置
        httpConnection.setRequestProperty("Range", "bytes=" + start);
        // 获得输入流
        InputStream input = httpConnection.getInputStream();
        return input;
    }

    private void saveFileAtSomePoint(long beginPoint, InputStream input) throws Exception {
        RandomAccessFile oSavedFile = new RandomAccessFile(fileName, "rw");
        long nPos = beginPoint;
        // 定位文件指针到 nPos 位置
        oSavedFile.seek(nPos);
        byte[] b = new byte[1024];
        int nRead;
        // 从输入流中读入字节流，然后写到文件中
        while ((nRead = input.read(b, 0, 1024)) > 0) {
            oSavedFile.write(b, 0, nRead);
        }
    }

}
