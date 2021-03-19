/*
 * 260. Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once
 * and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 */

package com.chang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem260 {

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        if (null == nums || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }

        int i = 0;
        for (Integer n : set) {
            if (0 == i) {
                res[0] = n;
                i++;
            } else {
                res[1] = n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem260 problem = new Problem260();
        // [3, 5]
        int[] nums1 = new int[]{1, 2, 1, 3, 2, 5};
        int[] res = problem.singleNumber(nums1);
        System.out.println("###########");

    }

    public int[] singleNumberExample(int[] nums) {
        int result[] = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // find one flag bit
        // this use rightmost set bit
        int bit = xor & ~(xor - 1);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & bit) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;
    }

}
