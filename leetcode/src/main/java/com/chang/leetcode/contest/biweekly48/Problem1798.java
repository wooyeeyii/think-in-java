/*
 * 1798. Maximum Number of Consecutive Values You Can Make
 *
 * You are given an integer array coins of length n which represents the n coins that you own. The value of the ith coin is coins[i].
 * You can make some value x if you can choose some of your n coins such that their values sum up to x.
 * Return the maximum number of consecutive integer values that you can make with your coins starting from and including 0.
 *
 * Note that you may have multiple coins of the same value.
 *
 * Example 1:
 * Input: coins = [1,3]
 * Output: 2
 * Explanation: You can make the following values:
 * - 0: take []
 * - 1: take [1]
 * You can make 2 consecutive integer values starting from 0.
 *
 * Example 2:
 * Input: coins = [1,1,1,4]
 * Output: 8
 * Explanation: You can make the following values:
 * - 0: take []
 * - 1: take [1]
 * - 2: take [1,1]
 * - 3: take [1,1,1]
 * - 4: take [4]
 * - 5: take [4,1]
 * - 6: take [4,1,1]
 * - 7: take [4,1,1,1]
 * You can make 8 consecutive integer values starting from 0.
 *
 * Example 3:
 * Input: nums = [1,4,10,3,1]
 * Output: 20
 *
 * Constraints:
 * coins.length == n
 * 1 <= n <= 4 * 104
 * 1 <= coins[i] <= 4 * 104
 *
 */
package com.chang.leetcode.contest.biweekly48;

import java.util.Arrays;

public class Problem1798 {

    public int getMaximumConsecutive(int[] coins) {
        if (null == coins || 0 == coins.length) {
            return 1;
        }
        Arrays.sort(coins);
        int right = 0;
        int idx = 0;
        while (idx < coins.length && coins[idx] <= right + 1) {
            right += coins[idx];
            idx++;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Problem1798 problem = new Problem1798();
        System.out.println(problem.getMaximumConsecutive(new int[]{1}));
        System.out.println(problem.getMaximumConsecutive(new int[]{1000}));
        System.out.println(problem.getMaximumConsecutive(new int[]{1000, 1001}));
        // 2
//        System.out.println(problem.getMaximumConsecutive(new int[]{1, 3}));
        // 8
//        System.out.println(problem.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
        // 20
//        System.out.println(problem.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}));
        //
        System.out.println(problem.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140}));
    }

    public int getMaximumConsecutiveExample(int[] A) {
        Arrays.sort(A);
        int res = 1;
        for (int a : A) {
            if (a > res) break;
            res += a;
        }
        return res;
    }

}
