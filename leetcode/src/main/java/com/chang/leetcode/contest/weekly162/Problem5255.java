package com.chang.leetcode.contest.weekly162;

public class Problem5255 {

    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int[] ind : indices) {
            rows[ind[0]] += 1;
            cols[ind[1]] += 1;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[j] + cols[i]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count++;
    }

}
