/**
 * Best Time to Buy and Sell Stock IV
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * <p>
 * Example 2:
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * <p>
 * solution link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem188 {

    /**
     * It's not difficult to get the DP recursive formula:
     * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     * For k transactions, on i-th day,
     * <p>
     * Time complexity is O(kn^2), space complexity is O(kn).
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        for (int m = 1; m <= k; m++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.min(min, prices[j] - dp[m - 1][j - 1]);
                dp[m][i] = Math.max(dp[m][i - 1], prices[i] - min);
            }
        }
        return dp[k][prices.length - 1];
    }

    /**
     * In the above code, min is repeated calculated. It can be easily improved as:
     * <p>
     * Time complexity is O(kn), space complexity is O(kn).
     */
    public int maxProfitDpImpro1(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        for (int m = 1; m <= k; m++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[m - 1][i - 1]);
                dp[m][i] = Math.max(dp[m][i - 1], prices[i] - min);
            }
        }
        return dp[k][prices.length - 1];
    }

    /**
     * If we slight swap the two 'for' loops:
     */
    public int maxProfitDpImpro2(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        int[] min = new int[k + 1];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int m = 1; m <= k; m++) {
                min[m] = Math.min(min[m], prices[i] - dp[m - 1][i - 1]);
                dp[m][i] = Math.max(dp[m][i - 1], prices[i] - min[m]);
            }
        }
        return dp[k][prices.length - 1];
    }

    /**
     * We need to save min for each transaction, so there are k 'min'.
     * We can find the second dimension (variable i) is only dependent on the previous one (i-1), so we can compact this dimension.
     * (We can choose the first dimension (variable k) as well since it is also only dependent on its previous one k-1, but can't compact both.)
     * <p>
     * So time complexity is O(kn), space complexity becomes O(k).
     */
    public int maxProfitDpImpro3(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[k + 1];
        int[] min = new int[k + 1];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int m = 1; m <= k; m++) {
                min[m] = Math.min(min[m], prices[i] - dp[m - 1]);
                dp[m] = Math.max(dp[m], prices[i] - min[m]);
            }
        }
        return dp[k];
    }

    /*********************************************************
     * k=1000000000, 数组超大时， leetcode会报错：Memory Limit Exceeded
     ********************************************************/

    /* 参考解法 */
    public int maxProfitSample(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        // to avoid memory limit exceeded error, we can optimize our solution
        // if we are allowed to do len/2 or more transactions, we can convert to problem of Stock II by using greedy algorithm
        if (k >= len / 2) {
            int result = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        /** sub-problem:
         * dp[i][j] represents max profit of first j + 1 prices by making i transactions
         *
         * base case:
         * dp[0][j] = 0 for 0 < j < prices.length, since 0 transaction will have no profit
         * dp[i][0] = 0 for 0 < i <= k, since there does not have any available prices
         */
        int[][] dp = new int[k + 1][len];

        /* recurrence relation */
        for (int i = 1; i <= k; i++) {
            // assume we buy stock at the first price
            int prevMax = -prices[0];
            for (int j = 1; j < len; j++) {

                /* dp[i][j] deciding the selling point
                 *  Similar to 0-1 knapsack problem, we have two candidates at here (use or not use):
                 *  1. if we do not use current new available price:
                 *     keep previous max profit dp[i][j-1] at current new available price without doing any new transaction
                 *  2. if we use current new available price:
                 *     throw previous max, update new max profit by doing one more transaction at current new price (bought new stock before, and sell it on current transaction)
                 *  By comparing these two max profit, we will keep the one with max value, and assign to dp[i][j]
                 * */

                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + prevMax);

                /* preMax deciding the buying point
                 *  in order to prepare previous price state for dp[i][j] in next iteration, we need to calculate
                 *  whether we want to use current price as buying price :
                 *  1. if we do not use one more transaction chance to buy new stock, and keep original buying price:
                 *     keep previous max profit, as preMax
                 *  2. if we use one more transaction chance to buy new stock:
                 *     use previous max profit with i - 1 transaction dp[i-1][j] minus new buying price, price[j],
                 *     then we will decide new max profit in next iteration
                 * */

                prevMax = Math.max(prevMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }


    public static void main(String[] args) {
        Problem188 problem = new Problem188();
        int[] stock1 = new int[]{2, 4, 1};
        System.out.println(2 == problem.maxProfit(2, stock1));
        int[] stock2 = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(7 == problem.maxProfit(2, stock2));
    }
}
