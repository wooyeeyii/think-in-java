/*
 * 91. Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
package com.chang.leetcode;

public class Problem91 {

    // s(n) = s(n-1) + (s(n-2),后2数)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem91 problem = new Problem91();
        System.out.println(0 == problem.numDecodings("00"));
        System.out.println(0 == problem.numDecodings("01"));
        System.out.println(0 == problem.numDecodings("012"));
        System.out.println(1 == problem.numDecodings("10"));
        System.out.println(0 == problem.numDecodings("1002"));
        System.out.println(1 == problem.numDecodings("101"));
        System.out.println(2 == problem.numDecodings("12"));
        System.out.println(3 == problem.numDecodings("226"));
    }
}
