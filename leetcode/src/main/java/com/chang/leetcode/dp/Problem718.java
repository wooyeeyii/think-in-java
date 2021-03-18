package com.chang.leetcode.dp;

public class Problem718 {

    public int findLength(int[] A, int[] B) {
        int max = 0;
        int m = A.length, n = B.length;
        // dp[i][j] is the length of longest common subarray ending with nums[i-1] and nums[j-1]
        // so, if A[i] != B[j], dp[i][j] is zero.
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    if (0 == i || 0 == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
