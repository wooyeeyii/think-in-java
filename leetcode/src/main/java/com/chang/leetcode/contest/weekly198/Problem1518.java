/*
 * 1518. Water Bottles
 *
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * Return the maximum number of water bottles you can drink.
 *
 * Example 1:
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13.
 *
 * Example 2:
 * Input: numBottles = 15, numExchange = 4
 * Output: 19
 * Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 *
 * Example 3:
 * Input: numBottles = 5, numExchange = 5
 * Output: 6
 *
 * Example 4:
 * Input: numBottles = 2, numExchange = 3
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 */
package com.chang.leetcode.contest.weekly198;

public class Problem1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }

        int drinks = numBottles / numExchange * numExchange;
        return drinks + numWaterBottles(numBottles % numExchange + drinks / numExchange, numExchange);
    }

    public static void main(String[] args) {
        Problem1518 problem = new Problem1518();
        System.out.println(problem.numWaterBottles(22, 6));
    }

    public int numWaterBottlesExample1(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles /= numExchange;
            ans += numBottles;
            numBottles += remainder;
        }
        return ans;
    }

    public int numWaterBottlesExample2(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }

}
