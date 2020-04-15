/**
 * 1200. Minimum Absolute Difference
 * <p>
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <p>
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * <p>
 * Example 1:
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * <p>
 * Example 2:
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * <p>
 * Example 3:
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 * <p>
 * Constraints:
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
package com.chang.leetcode.contest.weekly155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == arr || 1 >= arr.length) {
            return list;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                list.add(pair);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem1200 problem = new Problem1200();
        List<List<Integer>> res = problem.minimumAbsDifference(new int[]{4});
        List<List<Integer>> res0 = problem.minimumAbsDifference(new int[]{4, 2});

        // [[1,2],[2,3],[3,4]]
        List<List<Integer>> res1 = problem.minimumAbsDifference(new int[]{4, 2, 1, 3});
        // [[1,3]]
        List<List<Integer>> res2 = problem.minimumAbsDifference(new int[]{1, 3, 6, 10, 15});
        // [-14,-10],[19,23],[23,27]
        List<List<Integer>> res3 = problem.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
    }
}
