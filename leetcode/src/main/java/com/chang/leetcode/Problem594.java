/**
 * 594. Longest Harmonious Subsequence
 * <p>
 * We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * <p>
 * <p>
 * Note: The length of the input array will not exceed 20,000.
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem594 {

    // Memeory limit Exceed for [4289383,46930886,81692777,14636915,57747793,24238335,19885386,49760492,96516649,89641421]
    public int findLHSTooBig(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        int longest = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] == 0 || count[i + 1] == 0) {
                continue;
            }
            longest = Math.max(longest, count[i] + count[i + 1]);
        }

        return longest;
    }

    public int findLHS(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int longest = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int tmp = map.containsKey(entry.getKey() + 1) ? entry.getValue() + map.get(entry.getKey() + 1) : 0;
            if (tmp > longest) {
                longest = tmp;
            }
        }
        return longest;
    }

    // 先排序再算个数

    public static void main(String[] args) {
        Problem594 problem = new Problem594();
        System.out.println(5 == problem.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(problem.findLHS(new int[]{4289383, 46930886, 81692777, 14636915, 57747793, 24238335, 19885386, 49760492, 96516649, 89641421}));
    }


}
