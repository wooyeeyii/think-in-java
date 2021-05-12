package com.chang.leetcode;

public class Problem1374 {

    public String generateTheString(int n) {
        if (0 == n % 2) {
            return "a".repeat(n - 1) + "b";
        } else {
            return "a".repeat(n);
        }
    }

}
