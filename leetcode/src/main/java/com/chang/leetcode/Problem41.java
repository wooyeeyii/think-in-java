/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
package com.chang.leetcode;

public class Problem41 {

    public int firstMissingPositive(int[] nums) {
        int l = nums.length, idx;
        boolean zero = false;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0)
                zero = true;
            if (nums[i] <= 0)
                nums[i] = l + 1;
        }
        for (int i = 0; i < l; i++) {
            idx = Math.abs(nums[i]);
            if (idx <= l && nums[idx - 1] > 0)
                nums[idx - 1] = -nums[idx - 1];
        }
        for (int i = 0; i < l; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        Problem41 problem = new Problem41();
        int res = problem.firstMissingPositive(nums);
        System.out.println(res);
    }
}
