/**
 * 1753. Maximum Score From Removing Stones
 *
 * You are playing a solitaire game with three piles of stones of sizes a​​​​​​, b,​​​​​​ and c​​​​​​ respectively.
 * Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score.
 * The game stops when there are fewer than two non-empty piles (meaning there are no more available moves).
 *
 * Given three integers a​​​​​, b,​​​​​ and c​​​​​, return the maximum score you can get.
 *
 * Example 1:
 * Input: a = 2, b = 4, c = 6
 * Output: 6
 * Explanation: The starting state is (2, 4, 6). One optimal set of moves is:
 * - Take from 1st and 3rd piles, state is now (1, 4, 5)
 * - Take from 1st and 3rd piles, state is now (0, 4, 4)
 * - Take from 2nd and 3rd piles, state is now (0, 3, 3)
 * - Take from 2nd and 3rd piles, state is now (0, 2, 2)
 * - Take from 2nd and 3rd piles, state is now (0, 1, 1)
 * - Take from 2nd and 3rd piles, state is now (0, 0, 0)
 * There are fewer than two non-empty piles, so the game ends. Total: 6 points.
 *
 * Example 2:
 * Input: a = 4, b = 4, c = 6
 * Output: 7
 * Explanation: The starting state is (4, 4, 6). One optimal set of moves is:
 * - Take from 1st and 2nd piles, state is now (3, 3, 6)
 * - Take from 1st and 3rd piles, state is now (2, 3, 5)
 * - Take from 1st and 3rd piles, state is now (1, 3, 4)
 * - Take from 1st and 3rd piles, state is now (0, 3, 3)
 * - Take from 2nd and 3rd piles, state is now (0, 2, 2)
 * - Take from 2nd and 3rd piles, state is now (0, 1, 1)
 * - Take from 2nd and 3rd piles, state is now (0, 0, 0)
 * There are fewer than two non-empty piles, so the game ends. Total: 7 points.
 *
 * Example 3:
 * Input: a = 1, b = 8, c = 8
 * Output: 8
 * Explanation: One optimal set of moves is to take from the 2nd and 3rd piles for 8 turns until they are empty.
 * After that, there are fewer than two non-empty piles, so the game ends.
 *
 * Constraints:
 * 1 <= a, b, c <= 105
 */
package com.chang.leetcode.contest.weekly227;

import java.util.Arrays;

public class Problem1753 {

    public int maximumScore(int a, int b, int c) {
        int cnt = 0;
        Integer[] array = new Integer[]{a, b, c};
        Arrays.sort(array, (m, n) -> n - m);
        while (array[1] > 0) {
            array[0]--;
            array[1]--;
            cnt++;
            Arrays.sort(array, (m, n) -> n - m);
        }
        return cnt;
    }

    // nice math
    public int maximumScoreExample(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);

        // the goal is to isolate the largest element and extract the maximum possible value
        int sum1 = arr[0] + arr[1];
        int sum2 = arr[2];

        int res = 0;

        if (sum1 >= sum2) {
            // We can combine the 2 lower elements after utilising the largest of 3
            res = sum2 + (sum1 - sum2) / 2;
        } else {
            // We can combine the 2 lower elements with the largest element
            res = sum1;
        }
        return res;
    }

}
