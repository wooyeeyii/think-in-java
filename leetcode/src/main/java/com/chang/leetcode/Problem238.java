/**
 * 238. Product of Array Except Self
 * <p>
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * <p>
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 */
package com.chang.leetcode;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int zeroCount = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                product *= nums[i];
            } else {
                zeroCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                result[i] = 0;
            } else if (1 == zeroCount) {
                if (0 == nums[i]) {
                    result[i] = (int) product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = (int) product / nums[i];
            }
        }
        return result;
    }

    public int[] productExceptSelfTwoDirection(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= tmp;
            tmp *= nums[j];
        }
        return result;
    }


}
