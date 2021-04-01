/*
 * 1338. Reduce Array Size to The Half
 *
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 *
 * Example 1:
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
 *
 * Example 2:
 * Input: arr = [7,7,7,7,7,7]
 * Output: 1
 * Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 *
 * Example 3:
 * Input: arr = [1,9]
 * Output: 1
 *
 * Example 4:
 * Input: arr = [1000,1000,3,7]
 * Output: 1
 *
 * Example 5:
 * Input: arr = [1,2,3,4,5,6,7,8,9,10]
 * Output: 5
 *
 * Constraints:
 * 1 <= arr.length <= 10^5
 * arr.length is even.
 * 1 <= arr[i] <= 10^5
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1338 {

    // use priority queue
    // time complex count O(n) queue O(n * log2(n))
    public int minSetSizeSlow(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int len = 0;
        for (int n : arr) {
            len++;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        map.forEach((k, v) -> queue.offer(v));

        int cnt = 0, cntRemoved = 0;
        while (cntRemoved < len / 2) {
            cntRemoved += queue.poll();
            cnt++;
        }
        return cnt;
    }

    // space exchange for time
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int len = 0;
        for (int n : arr) {
            len++;
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, map.get(n));
        }

        int[] record = new int[max + 1];
        map.forEach((k, v) -> record[v]++);

        int cnt = 0, cntRemoved = 0, idx = max;
        while (cntRemoved < len / 2) {
            if (record[idx] != 0) {
                cntRemoved += idx;
                record[idx]--;
                cnt++;
            } else {
                idx--;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Problem1338 problem = new Problem1338();
        System.out.println(problem.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(problem.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println(problem.minSetSize(new int[]{1, 9}));
        System.out.println(problem.minSetSize(new int[]{1000, 1000, 3, 7}));
        System.out.println(problem.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

}
