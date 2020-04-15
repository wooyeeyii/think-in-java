/**
 * 509. Fibonacci Number
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Example 2:
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * Example 3:
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 0 ≤ N ≤ 30.
 */
package com.chang.leetcode.math;

public class Problem509 {

    public int fib(int n) {
        if (0 == n) return 0;
        int pre = 0;
        int m = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = m;
            m = m + pre;
            pre = tmp;
        }
        return m;
    }

    public static void main(String[] args) {
        Problem509 problem = new Problem509();
        System.out.println(0 == problem.fib(0));
        System.out.println(1 == problem.fib(1));
        System.out.println(1 == problem.fib(2));
        System.out.println(2 == problem.fib(3));
        System.out.println(3 == problem.fib(4));
    }
}
