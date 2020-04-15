/**
 * 397. Integer Replacement
 * <p>
 * Given a positive integer n and you can do operations as follow:
 * <p>
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * <p>
 * What is the minimum number of replacements needed for n to become 1?
 * <p>
 * Example 1:
 * Input:
 * 8
 * Output:
 * 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * <p>
 * Example 2:
 * Input:
 * 7
 * Output:
 * 4
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */
package com.chang.leetcode;

public class Problem397 {

    // 100000000
    // Memory Limit Exceeded
    public int integerReplacementSlow(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (0 == i % 2) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[(i - 1) / 2], dp[(i + 1) / 2]) + 2;
            }
        }

        return dp[n];
    }

    public int integerReplacement(int ns) {
        int count = 0;
        if (1 >= ns) {
            return 0;
        }
        long n = Long.valueOf(ns);
        while (n > 3) {
            if ((n & 0b1) == 1) {
                if ((n & 0b10) == 0b10) {
                    n = n + 1;
                } else {
                    n = n - 1;
                }
            } else {
                n = n >> 1;
            }
            count++;
        }
        return n == 3 ? (count + 2) : count + 1;
    }

    public static void main(String[] args) {
        Problem397 problem = new Problem397();
        System.out.println(0 == problem.integerReplacement(1));
        System.out.println(1 == problem.integerReplacement(2));
        System.out.println(2 == problem.integerReplacement(3));
        System.out.println(3 == problem.integerReplacement(8));
        System.out.println(4 == problem.integerReplacement(7));
        System.out.println(32 == problem.integerReplacement(2147483647));
    }
}
