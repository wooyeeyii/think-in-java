/*
 * 153. Find Minimum in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
package com.chang.leetcode.array;

public class Problem153 {
    public int findMin(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }

        int startPos = 0;
        int endPos = nums.length - 1;
        int midPos = (startPos + endPos) / 2;
        while (startPos < midPos && midPos < endPos) {
            if (nums[midPos] < nums[endPos]) {
                // 最小值在前半段
                endPos = midPos;
            } else if (nums[midPos] > nums[startPos]) {
                // 最小值在后半段
                startPos = midPos;
            }
            midPos = (startPos + endPos) / 2;
        }

        return nums[startPos] > nums[endPos] ? nums[endPos] : nums[startPos];
    }

    public static void main(String[] args) {
        Problem153 problem = new Problem153();
        int[] array1 = new int[]{3, 4, 5, 1, 2};
        int[] array2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] array3 = new int[]{0};
        System.out.println(problem.findMin(array1));
        System.out.println(problem.findMin(array2));
        System.out.println(problem.findMin(array3));
    }
}
