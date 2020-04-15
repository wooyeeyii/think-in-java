/**
 * Best Time to Buy and Sell Stock III
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * <p>
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * Problem188 Best Time to Buy and Sell Stock IV
 */
package com.chang.leetcode;

public class Problem123 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {                              // Assume we only have 0 money at first
            hold1 = Math.max(hold1, -i);          // The maximum if we've just buy  1st stock so far.
            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold2 = Math.max(hold2, release1 - i);  // The maximum if we've just buy  2nd stock so far.
            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        Problem123 problem = new Problem123();
        int[] stock1 = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(6 == problem.maxProfit(stock1));
        int[] stock2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(4 == problem.maxProfit(stock2));
        int[] stock3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(0 == problem.maxProfit(stock3));
        int[] stock4 = new int[]{1, 2, 3, 2, 5, 1, 2};
        System.out.println(5 == problem.maxProfit(stock4));
        int[] stock5 = new int[]{1, 2, 3, 2, 5, 1, 4};
        System.out.println(7 == problem.maxProfit(stock5));
    }
}
