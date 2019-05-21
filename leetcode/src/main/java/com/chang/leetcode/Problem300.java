/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
package com.chang.leetcode;

public class Problem300 {

    public int lengthOfLIS(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && (dp[j] + 1) > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int left = 0, right = size;
            while (left != right) {
                int m = left + (right - left) / 2;
                // 只能这么写，不能使用>做判断，否则会报错
                if (tails[m] < x)
                    left = m + 1;
                else
                    right = m;
            }
            tails[left] = x;
            if (left == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        Problem300 problem = new Problem300();
        int[] nums1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(4 == problem.lengthOfLIS2(nums1));
        int[] nums2 = new int[]{2, 2};
        System.out.println(1 == problem.lengthOfLIS2(nums2));
        int[] nums3 = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(3 == problem.lengthOfLIS2(nums3));
    }


    public int lengthOfLISExample(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }


}
