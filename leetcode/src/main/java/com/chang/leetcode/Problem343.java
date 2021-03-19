/*
 * 343. Integer Break
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
package com.chang.leetcode;

public class Problem343 {

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = i - 1;
            for (int j = 2; j <= i / 2; j++) {
                int a = Math.max(j, dp[i]);
                int b = Math.max((i - j), dp[i - j]);
                if (a * b > max) {
                    max = a * b;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem343 problem = new Problem343();
        System.out.println(1 == problem.integerBreak(2));
        System.out.println(2 == problem.integerBreak(3));
        System.out.println(36 == problem.integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }


}
