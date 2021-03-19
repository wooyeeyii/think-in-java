/*
 * 456. 132 Pattern
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak
 * such that i < j < k and ai < ak < aj. Design an algorithm that takes
 * a list of n numbers as input and checks whether there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem456 {

    // Time Limit Exceeded  O(n^3)
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int m = j + 1; m < len; m++) {
                    if (nums[i] < nums[m] && nums[m] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem456 problem = new Problem456();

        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(!problem.find132pattern(nums1));
        int[] nums2 = new int[]{3, 1, 4, 2};
        System.out.println(problem.find132pattern(nums2));
        int[] nums3 = new int[]{-1, 3, 2, 0};
        System.out.println(problem.find132pattern(nums3));
    }

    // O(n^2)
    public boolean find132pattern2(int[] nums) {
        for (int j = 0, min = Integer.MAX_VALUE; j < nums.length; j++) {
            min = Math.min(nums[j], min);
            if (min == nums[j]) continue;

            for (int k = nums.length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j]) return true;
            }
        }

        return false;
    }

    // O(n)
    public boolean find132pattern3(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }

        return false;
    }

    // One-pass O(n) solution
    public boolean find132pattern4(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }

}
