/**
 * 279. Perfect Squares
 * Medium
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * <p>
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem279 {

    // wrong answer 19 = 2 * 9 + 1   3
    public int numSquaresWrong(int m) {
        int count = 0;
        int n = m;
        while (n >= 4) {
            int sq = (int) Math.sqrt(n);
            count++;
            n = n - sq * sq;
        }
        if (0 != n) {
            for (int i = (int) Math.sqrt(m); i >= 2; i--) {
                if (0 == m % (i * i)) {
                    return m / (i * i);
                }
            }
        }

        return count + n;
    }

    public static void main(String[] args) {
        Problem279 problem = new Problem279();
        System.out.println(3 == problem.numSquares(12));
        System.out.println(2 == problem.numSquares(13));
        System.out.println(3 == problem.numSquares(19));
    }

    // DP
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        if (is_sqrt(n))
            return 1;
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i < n; i++) {
            if (is_sqrt(n - i * i))
                return 2;
        }
        return 3;
    }

    public boolean is_sqrt(int n) {
        int m = (int) Math.sqrt(n);
        if (m * m == n)
            return true;
        else
            return false;
    }


}
