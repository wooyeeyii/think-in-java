package com.chang.leetcode;

public class Problem7 {

    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] rs = s.toCharArray();
        int start = 0;
        if (s.charAt(0) == '-') {
            start = 1;
            rs[0] = '-';
        }
        int end = s.length() - 1;
        while (end > start) {
            char tmp = rs[start];
            rs[start] = rs[end];
            rs[end] = tmp;
            start++;
            end--;
        }
        String reverseStr = String.valueOf(rs);
        try {
            return Integer.valueOf(reverseStr);
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverseMehtod2(int x) {
        long y = 0;
        boolean negative = x < 0 ? true : false;
        x = x < 0 ? -x : x;
        while (x > 0) {
            y *= 10;
            y += x % 10;
            x = x / 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }
        return negative ? (int) -y : (int) y;
    }

}
