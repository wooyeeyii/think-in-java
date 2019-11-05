package com.chang.leetcode.contest.weekly161;

public class Problem1247 {

    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int xDiff = 0;
        int yDiff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') xDiff++;
                else yDiff++;
            }
        }

        if ((xDiff + yDiff) % 2 != 0) return -1;

        if (xDiff % 2 == 0) {
            return (xDiff + yDiff) / 2;
        } else {
            return xDiff / 2 + yDiff / 2 + 2;
        }

    }

    public static void main(String[] args) {
        Problem1247 problem = new Problem1247();
        System.out.println(1 == problem.minimumSwap("xx", "yy"));
        System.out.println(2 == problem.minimumSwap("xy", "yx"));
        System.out.println(-1 == problem.minimumSwap("xx", "yx"));
        System.out.println(4 == problem.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }


}
