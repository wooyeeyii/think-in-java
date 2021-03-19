/*
 * 172. Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Example 3:
 * Input: n = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 10^4
 */
package com.chang.leetcode.math;

public class Problem172 {

    // only 2 * 5, you can get 10, 2 is always ample, so we only need count number of 5;
    // some number 25, 125, 625, contains multiple 5, so we need recalculate them.
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n / 5;
            cnt += tmp;
            n = tmp;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem172 problem = new Problem172();
        // 0
        System.out.println(0 == problem.trailingZeroes(0));
        // 0
        System.out.println(0 == problem.trailingZeroes(3));
        // 1
        System.out.println(1 == problem.trailingZeroes(5));
        // 2
        System.out.println(2 == problem.trailingZeroes(10));
        // 3
        System.out.println(3 == problem.trailingZeroes(15));
    }

}
