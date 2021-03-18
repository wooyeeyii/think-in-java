/*
 * 628. Maximum Product of Three Numbers
 *
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 24
 *
 * Example 3:
 * Input: nums = [-1,-2,-3]
 * Output: -6
 *
 * Constraints:
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 */
package com.chang.leetcode.math;

public class Problem628 {

    // find max three positive and two min negative
    public int maximumProduct(int[] nums) {
        // small to big
        int[] max = new int[3];
        int[] min = new int[2];
        for (int i : nums) {
            if (i > max[0]) {
                if (i > max[2]) {
                    max[0] = max[1];
                    max[1] = max[2];
                    max[2] = i;
                } else if (i > max[1]) {
                    max[0] = max[1];
                    max[1] = i;
                } else {
                    max[0] = i;
                }
            } else if (i < min[1]) {
                if (i < min[0]) {
                    min[1] = min[0];
                    min[0] = i;
                } else {
                    min[1] = i;
                }
            }
        }

        if (0 == min[0]) {
            return max[0] * max[1] * max[2];
        } else {
            return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[2]);
        }
    }

}
