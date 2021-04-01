/*
 * 1014. Best Sightseeing Pair
 *
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
 * Two sightseeing spots i and j have a distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j:
 * the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 * Example 1:
 * Input: values = [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * Example 2:
 * Input: values = [1,2]
 * Output: 2
 *
 * Constraints:
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 */
package com.chang.leetcode;

public class Problem1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int cur = 0, max = 0;
        for (int n : values) {
            max = Math.max(max, cur + n - 1);
            cur = Math.max(n, cur - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem1014 problem = new Problem1014();
        System.out.println(problem.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(problem.maxScoreSightseeingPair(new int[]{1, 2}));
    }

}
