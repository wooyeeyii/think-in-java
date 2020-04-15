/**
 * 516. Longest Palindromic Subsequence
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * <p>
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 */
package com.chang.leetcode.dp;

public class Problem516 {

    /**
     * Why can't we change the loop in this way:
     * for(int i = 0; i<s.length();i++){
     *     for (int j = 0; j <= i; j++) {
     *         ....
     *         dp[j][i] = dp[j + 1][i - 1] + 2;
     *         ....
     *     }
     * }
     * because if(s[i]!=s[j]), we need to know about the dp[j+1][i] and dp[j][i-1],
     * but if you start j=0, you can't cover the dp[j+1][i],
     * because it's the next step in for loop, only start from j=i-1 can solve this problem.
     */


    /**
     * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
     * State transition:
     * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
     * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
     * Initialization: dp[i][i] = 1
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Problem516 problem = new Problem516();
        System.out.println(4 == problem.longestPalindromeSubseq("bbbab"));
        System.out.println(2 == problem.longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseqDP(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
