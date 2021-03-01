/**
 * 1752. Check if Array Is Sorted and Rotated
 *
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 * then rotated some number of positions (including zero). Otherwise, return false.
 * There may be duplicates in the original array.
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 *
 * Example 2:
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 *
 * Example 4:
 * Input: nums = [1,1,1]
 * Output: true
 * Explanation: [1,1,1] is the original sorted array.
 * You can rotate any number of positions to make nums.
 *
 * Example 5:
 * Input: nums = [2,1]
 * Output: true
 * Explanation: [1,2] is the original sorted array.
 * You can rotate the array by x = 5 positions to begin on the element of value 2: [2,1].
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
package com.chang.leetcode.contest.weekly227;

public class Problem1752 {

    public boolean checkLoop(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == len - 1) {
            return true;
        }

        i += 1;
        while (i < len - 1 && nums[i] <= nums[0] && nums[i] <= nums[i + 1]) {
            i++;
        }
        return i == len - 1;
    }

    public static void main(String[] args) {
        Problem1752 problem = new Problem1752();
        System.out.println(problem.check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(!problem.check(new int[]{2, 1, 3, 4}));
        System.out.println(problem.check(new int[]{1, 2, 3}));
        System.out.println(problem.check(new int[]{1, 1, 1}));
        System.out.println(problem.check(new int[]{2, 1}));
        System.out.println(problem.check(new int[]{7, 9, 1, 1, 1, 3}));
        System.out.println(problem.check(new int[]{15, 20, 21, 22, 22, 23, 24, 25, 28, 28, 30, 35, 36, 37, 38, 43, 43, 44, 52, 62, 63,
                67, 67, 67, 68, 71, 76, 77, 78, 80, 80, 83, 84, 84, 88, 89, 93, 94, 100, 6, 10, 10, 12, 13, 15, 15}));
    }

    public boolean check(int[] nums) {
        int k = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }

}