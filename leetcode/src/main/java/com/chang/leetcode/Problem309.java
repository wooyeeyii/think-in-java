/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
package com.chang.leetcode;

public class Problem309 {

    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = prices[1] > prices[0]? prices[1] - prices[0] : 0;
        for(int i = 2; i < prices.length; i++) {
            dp[i + 1] = Math.max(dp[0], dp[1], )
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 2};
        Problem309 problem = new Problem309();
        // [buy, sell, cooldown, buy, sell]
        System.out.println(3 == problem.maxProfit(nums));
    }
}
