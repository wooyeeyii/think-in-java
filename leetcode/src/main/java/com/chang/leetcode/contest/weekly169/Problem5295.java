package com.chang.leetcode.contest.weekly169;

public class Problem5295 {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int m = n / 2;
        int pos = 0;
        for (int i = -m; i < 0; i++) {
            res[pos++] = i;
        }
        if (n % 2 != 0) {
            res[pos++] = 0;
        }
        for (int i = 1; i <= m; i++) {
            res[pos++] = i;
        }
        return res;
    }

}
