/*
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * Your function should return length = 7, with the first seven elements
 * of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
package com.chang.leetcode;

public class Problem80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 1;
        int dupCount = 1;
        int dupEle = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == dupEle) {
                dupCount++;
                if (dupCount <= 2) {
                    nums[index++] = dupEle;
                }
            } else {
                dupEle = nums[i];
                dupCount = 1;
                nums[index++] = dupEle;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Problem80 problem = new Problem80();
        int[] nums1 = new int[]{1, 1, 2, 2, 3};
        System.out.println(5 == problem.removeDuplicates(nums1));
        for (int i = 0; i < 5; i++) {
            System.out.println(nums1[i] + ", ");
        }
        System.out.println("###################");

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(7 == problem.removeDuplicates(nums2));
        for (int i = 0; i < 7; i++) {
            System.out.println(nums2[i] + ", ");
        }
        System.out.println("###################");
    }
}
