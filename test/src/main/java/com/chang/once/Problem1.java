package com.chang.once;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println(in.next());
        String s = "a3b2";
        printString(s);
    }

    public static void printString(String s) {
        if (null == s || 0 == s.length()) {
            System.out.print("");
        }

        List<String[]> list = new ArrayList<>();
        int idx = 0;
        while (null != s && 0 < s.length()) {
            idx = nextString(s);
            String alpha = s.substring(0, idx);
            s = s.substring(idx);
            idx = nextInt(s);
            String cnt = s.substring(0, idx);
            s = s.substring(idx);
            list.add(new String[]{alpha, cnt});
        }

        bubbleSort(list);
        for (int i = 0; i < list.size(); i++) {
            String[] s1 = list.get(i);
            for (int j = 0; j < Integer.valueOf(s1[1]); j++) {
                System.out.print(s1[0]);
            }
        }
    }

    private static void bubbleSort(List<String[]> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                String[] s1 = list.get(j);
                String[] s2 = list.get(j + 1);
                if (Integer.valueOf(s1[1]).intValue() != Integer.valueOf(s2[1]).intValue()) {
                    swap(list, i, j);
                } else {
                    if (s1[0].compareTo(s2[0]) > 0) {
                        swap(list, i, j);
                    }
                }
            }
        }
    }

    private static void swap(List<String[]> list, int i, int j) {
        String[] tmp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tmp);
    }

    private static int nextInt(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' > c || c > '9') {
                break;
            }
        }
        return i;
    }

    private static int nextString(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                break;
            }
        }
        return i;
    }

}
