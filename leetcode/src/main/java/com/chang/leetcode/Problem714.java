/*
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * Example 2:
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 * Constraints:
 * 1 <= prices.length <= 5 * 10^4
 * 1 <= prices[i] < 5 * 10^4
 * 0 <= fee < 5 * 10^4
 */
package com.chang.leetcode;

public class Problem714 {

    // TimeLimitExceed
    public int maxProfitTooSlow(int[] prices, int fee) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] + fee < prices[i]) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] - fee + (0 == j ? 0 : dp[j - 1]));
                }
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Problem714 problem = new Problem714();
        // 8
        System.out.println(problem.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        // 6
        System.out.println(problem.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    // pay the fee when buy stock
    public int maxProfit1(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }

        return T_ik0;
    }

    // pay the fee when sell stock
    // pay attention, use long. why ?
    // T_ik0 may be less than MIN int.
    public int maxProfit(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return (int)T_ik0;
    }



}
