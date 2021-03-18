package com.chang.leetcode.dp;

public class Problem1143 {

    public int longestCommonSubsequenceSlow(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp[i][j] is the length of longest common subsequence in string nums[i-1] and nums[j-1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(Math.max(1 + dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int[][] L = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        Problem1143 problem = new Problem1143();
        System.out.println(problem.longestCommonSubsequence("abcde", "ace"));
    }

}
