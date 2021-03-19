/*
 * 464. Can I Win
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 * What if we change the game so that players cannot re-use integers?
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 *
 * Example
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * The key part for the top-down dp strategy is that we need to avoid repeatedly solving sub-problems.
 * Instead, we should use some strategy to "remember" the outcome of sub-problems
 */

public class Problem464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        boolean flag = canIWin(desiredTotal, new int[maxChoosableInteger], map);
        return flag;
    }

    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
        String curr = Arrays.toString(state);
        if (hashMap.containsKey(curr)) return hashMap.get(curr);
        for (int i = 0; i < state.length; i++) {
            // 若未使用，则1号选手选择使用 i
            if (state[i] == 0) {
                state[i] = 1;
                // 赢的条件：如果选的这个数大于等于目标数字，或者对手在这种情况下是输的，那么，我在这情况下就是赢的
                if (total <= i + 1 || !canIWin(total - (i + 1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        hashMap.put(curr, false);
        return false;
    }

    public static void main(String[] args) {
        Problem464 problem = new Problem464();
        System.out.println(!problem.canIWin(10, 11));
        System.out.println(!problem.canIWin(10, 40));
    }

}
