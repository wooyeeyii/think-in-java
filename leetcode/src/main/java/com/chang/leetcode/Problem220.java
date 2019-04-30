/**
 * 220. Contains Duplicate III
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i]
 * and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
package com.chang.leetcode;

import java.util.TreeSet;

public class Problem220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            int len = Math.min(i + k, nums.length - 1);
            for (int j = i + 1; j <= len; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= (long) t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem220 problem = new Problem220();
        int[] nums1 = new int[]{1, 2, 3, 1};
        System.out.println(true == problem.containsNearbyAlmostDuplicate(nums1, 3, 0));
        int[] nums2 = new int[]{1, 0, 1, 1};
        System.out.println(true == problem.containsNearbyAlmostDuplicate(nums2, 1, 2));
        int[] nums3 = new int[]{1, 5, 9, 1, 5, 9};
        System.out.println(false == problem.containsNearbyAlmostDuplicate(nums3, 2, 3));
        int[] nums4 = new int[]{2, 2};
        System.out.println(true == problem.containsNearbyAlmostDuplicate(nums4, 3, 0));
        int[] nums5 = new int[]{-1, 2147483647};
        System.out.println(false == problem.containsNearbyAlmostDuplicate(nums5, -1, 2147483647));
    }

    // 存在超界问题
    public boolean containsNearbyAlmostDuplicateExample(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {
            final Integer floor = values.floor(nums[ind] + t);
            if (floor != null && floor >= nums[ind]) {
                return true;
            }
            final Integer ceil = values.ceiling(nums[ind] - t);
            if (ceil != null && ceil <= nums[ind]) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }
        return false;
    }
}
