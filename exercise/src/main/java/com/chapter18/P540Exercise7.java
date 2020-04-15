package com.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class P540Exercise7 {
    public static void main(String[] args) throws IOException {
        InverseReadbyLinkedList inverseReadbyLinkedList = new InverseReadbyLinkedList();
        String str = inverseReadbyLinkedList.inverseRead("BufferedInputFile.java");
        System.out.println(str);
    }

}

class InverseReadbyLinkedList {
    public String inverseRead(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        List<String> list = new LinkedList<String>();

        while ((s = in.readLine()) != null) {
            //list.add(s + "\n");
            list.add(s.toUpperCase() + "\n");
        }
        in.close();

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }


        return sb.toString();
    }
}
