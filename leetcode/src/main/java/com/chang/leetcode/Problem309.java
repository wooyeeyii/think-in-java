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

    // buy[i] = max(sell[i-2]-price, buy[i-1])
    // sell[i] = max(buy[i-1]+price, sell[i-1])
    public int maxProfit(int[] prices) {
        if(null == prices || 2 > prices.length) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = -prices[1] > buy[0]? -prices[1] : buy[0];
        sell[1] = (prices[1] - prices[0]) > 0 ? (prices[1] - prices[0]) : 0;
        for(int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 2};
        Problem309 problem = new Problem309();
        // [buy, sell, cooldown, buy, sell]
        System.out.println(3 == problem.maxProfit(nums1));

        int[] nums2 = new int[] {2,1};
        System.out.println(0 == problem.maxProfit(nums2));
    }


    public int maxProfitExample(int[] prices) {
        if(null == prices || 2 > prices.length) {
            return 0;
        }

        int preBuy = 0, preSell = 0, buy = Integer.MIN_VALUE, sell = 0;
        for(int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }

}
