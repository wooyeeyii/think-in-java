/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem55 {

    // 思路，找0，若能成功跳过0点，则能直达最终点
    // 记录最大跳跃
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (0 == nums[0]) {
            return false;
        }
        int[] record = new int[nums.length];
        Arrays.fill(record, 0);
        int nextStart = 0;
        while (nextStart < nums.length - 1) {
            int start = nextStart;
            while (nextStart < nums.length - 1 && nums[nextStart] != 0) {
                nextStart++;
            }
            int end = nextStart - 1;
            while (nextStart < nums.length - 1 && nums[nextStart] == 0) {
                nextStart++;
            }

            // 记录跳跃位置
            int index = end;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > index) {
                    index = nums[i] + i;
                }
            }
            while (index < nums.length - 1 && 0 == nums[index]) {
                index--;
            }
            for (int i = start; i < Math.min(nums.length, index); i++) {
                record[i] = 1;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (0 == record[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Problem55 problem = new Problem55();
        int[] nums1 = new int[]{2, 3, 1, 1, 4};
        System.out.println(true == problem.canJump(nums1));
        int[] nums2 = new int[]{3, 2, 1, 0, 4};
        System.out.println(false == problem.canJump(nums2));
        int[] nums3 = new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0,
                8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0,
                4, 8, 6, 0,
                3, 2, 8, 7, 6, 5, 1, 7, 0,
                3, 4, 8, 3, 5, 9, 0,
                4, 0,
                1, 0,
                5, 9, 2, 0,
                7, 0,
                2, 1, 0,
                8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0,
                1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0,
                7, 5};
        System.out.println(true == problem.canJump(nums3));
        int[] nums4 = new int[]{1, 0, 1, 0};
        System.out.println(false == problem.canJump(nums4));
        int[] nums5 = new int[]{2, 0, 0};
        System.out.println(true == problem.canJump(nums5));
    }

    public boolean canJumpExample(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
