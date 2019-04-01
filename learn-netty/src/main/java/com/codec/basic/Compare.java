package com.codec.basic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Compare {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TestClass test = new TestClass();
        test.buildUserID(100).buildUserName("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(test);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is : " + b.length);
        bos.close();
        System.out.println("-------------------------------------");
        System.out.println("The byte array serializable length is : "
                + test.codeC().length);
    }

}
