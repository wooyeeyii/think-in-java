/**
 * 532. K-diff Pairs in an Array
 * <p>
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * <p>
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * <p>
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * <p>
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem532 {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        int count = 0;
        int len = nums.length;
        Arrays.sort(nums);
        if (0 != k) {
            for (int i = 0; i < len; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (j > 0 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    if (nums[i] - nums[j] == k) {
                        count += 1;
                    }
                }
            }
        } else {
            int i = 0;
            while (i < len - 1) {
                if (nums[i + 1] == nums[i]) count++;
                while (i < len - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem532 problem = new Problem532();
        int[] nums1 = new int[]{3, 1, 4, 1, 5};
        System.out.println(2 == problem.findPairsExample(nums1, 2));
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(4 == problem.findPairsExample(nums2, 1));
        int[] nums3 = new int[]{1, 3, 1, 5, 4};
        System.out.println(1 == problem.findPairsExample(nums3, 0));
    }

    public int findPairsExample(int[] nums, int diff) {
        if (nums == null || nums.length == 0 || diff < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Integer count = 0;
        if (0 == diff) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.containsKey(entry.getKey() + diff)) {
                    count++;
                }
            }
        }
        return count;
    }
}
