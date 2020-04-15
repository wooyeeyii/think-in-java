/**
 * 322. Coin Change
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem322 {

    // Time Limit Exceeded
    public int coinChangeTooSlow(int[] coins, int amount) {
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        Arrays.sort(coins);
        coinChangeRec(coins, coins.length - 1, amount, 0, res);
        for (int n : res) {
            if (n < min) {
                min = n;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void coinChangeRec(int[] coins, int pos, int left, int count, List<Integer> res) {
        if (pos < 0 || left < 0) {
            return;
        }
        if (0 == left % coins[pos]) {
            count += left / coins[pos];
            res.add(count);
            return;
        }

        for (int i = left / coins[pos]; i >= 0; i--) {
            coinChangeRec(coins, pos - 1, left - i * coins[pos], count + i, res);
        }

        return;
    }


    public static void main(String[] args) {
        Problem322 problem = new Problem322();
        int[] coins1 = new int[]{1, 2, 5};
        System.out.println(3 == problem.coinChange(coins1, 11));
        int[] coins2 = new int[]{2};
        System.out.println(-1 == problem.coinChange(coins2, 3));
        int[] coins3 = new int[]{186, 419, 83, 408};
        System.out.println(20 == problem.coinChange(coins3, 6249));
        int[] coins4 = new int[]{1, 8, 9};
        System.out.println(2 == problem.coinChange(coins4, 16));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;
        dp[0] = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    if (min == -1 || dp[sum - coin] + 1 < min) {
                        min = dp[sum - coin] + 1;
                    }
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public int coinChangeExample222(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

}
