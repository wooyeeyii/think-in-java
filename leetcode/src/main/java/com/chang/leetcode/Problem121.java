/**
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
package com.chang.leetcode;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPos = 0;
        int buyPos = 0;
        int sellPos = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length - 1; i++) {
            //下降趋势
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            if(i == prices.length - 1) {
                break;
            }
            minPos = minValue < prices[i]? minPos : i;
            minValue = Math.min(minValue, prices[i]);

            //上升趋势
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            if(max < prices[i] - minValue) {
                buyPos = minPos;
                sellPos = i;
            }
            max = Math.max(max, prices[i] - minValue);
        }
        System.out.println("buyPos: " + buyPos + ", sellPos: " + sellPos);
        return max;
    }

    public int maxProfitSample(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int release = 0;
        for (int i : prices) {
            hold = Math.max(hold, -i);
            release = Math.max(release, hold + i);
        }
        return release;
    }

    public static void main(String[] args) {
        Problem121 problem = new Problem121();
        int[] stock1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(5 == problem.maxProfit(stock1));
        int[] stock2 = new int[]{7, 6, 4, 3, 1};
        System.out.println(0 == problem.maxProfit(stock2));
        int[] stock3 = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(5 == problem.maxProfit(stock3));
    }
}
