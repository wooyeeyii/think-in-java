/**
 * 518. Coin Change 2
 * <p>
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 * <p>
 * Note:
 * You can assume that
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */
package com.chang.leetcode.dp;

import java.util.Arrays;

public class Problem518 {

    // wrong 3会重复计算1+2 和2+1
    public int changeWrong(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            int sum = 0;
            for (int c : coins) {
                if ((i - c) >= 0) {
                    sum += dp[i - c];
                } else {
                    break;
                }
            }
            dp[i] = sum;
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Problem518 problem = new Problem518();
        System.out.println(4 == problem.change(5, new int[]{1, 5, 2}));
        System.out.println(0 == problem.change(3, new int[]{2}));
        System.out.println(1 == problem.change(10, new int[]{10}));
    }

    /**
     * This is a classic knapsack problem. Honestly, I'm not good at knapsack problem, it's really tough for me.
     * <p>
     * dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
     * State transition:
     * <p>
     * not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
     * using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1]
     * by using first i coins(including ith), which is dp[i][j-coins[i-1]]
     * Initialization: dp[i][0] = 1
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], then we can optimize the space by only using one-dimension array.
     */
    public int changeImpro(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
