/**
 * 1217. Play with Chips
 * <p>
 * There are some chips, and the i-th chip is at position chips[i].
 * <p>
 * You can perform any of the two following types of moves any number of times (possibly zero) on any chip:
 * <p>
 * Move the i-th chip by 2 units to the left or to the right with a cost of 0.
 * Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
 * There can be two or more chips at the same position initially.
 * <p>
 * Return the minimum cost needed to move all the chips to the same position (any position).
 * <p>
 * Example 1:
 * Input: chips = [1,2,3]
 * Output: 1
 * Explanation: Second chip will be moved to positon 3 with cost 1. First chip will be moved to position 3 with cost 0. Total cost is 1.
 * <p>
 * Example 2:
 * Input: chips = [2,2,2,3,3]
 * Output: 2
 * Explanation: Both fourth and fifth chip will be moved to position two with cost 1. Total minimum cost will be 2.
 * <p>
 * Constraints:
 * <p>
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 */
package com.chang.leetcode.contest.weekly157;

public class Problem1217 {

    public int minCostToMoveChips(int[] chips) {
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return evenCount > oddCount ? oddCount : evenCount;
    }

    public static void main(String[] args) {
        Problem1217 problem = new Problem1217();
        System.out.println(1 == problem.minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(2 == problem.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }


}
