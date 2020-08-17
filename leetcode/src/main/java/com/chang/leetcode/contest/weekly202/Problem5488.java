package com.chang.leetcode.contest.weekly202;

public class Problem5488 {

    public int minOperations(int n) {
        if (n % 2 == 0) {
            return n / 2 * n / 2;
        } else {
            return (n - 1) / 2 * (n + 1) / 2;
        }
    }

}
