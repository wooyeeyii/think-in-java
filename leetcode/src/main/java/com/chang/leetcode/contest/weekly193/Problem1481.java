/*
 * 1481. Least Number of Unique Integers after K Removals
 *
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 * Example 1:
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 *
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
package com.chang.leetcode.contest.weekly193;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        map.forEach((key, value) -> {
            queue.offer(new int[]{key, value});
        });

        for (int i = 0; !queue.isEmpty() && (queue.peek())[1] + i <= k; ) {
            i += queue.poll()[1];
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Problem1481 problem = new Problem1481();
        System.out.println(problem.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(problem.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        System.out.println(problem.findLeastNumOfUniqueInts(new int[]{1}, 1));
    }

    public int findLeastNumOfUniqueIntsExample(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k >= arr.length)
            return 0;

        Arrays.sort(arr);
        int uniq = 0;
        int bench = arr[0];
        arr[uniq] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == bench) {
                arr[uniq]++;
            } else {
                bench = arr[i];
                uniq++;
                arr[uniq] = 1;
            }
        }
        uniq++;

        Arrays.sort(arr, 0, uniq);
        int sum = 0;
        for (int i = 0; i < uniq; i++) {
            sum += arr[i];
            if (sum > k)
                return uniq - i;
            else if (sum == k)
                return uniq - i - 1;
        }
        return 1;
    }

}
