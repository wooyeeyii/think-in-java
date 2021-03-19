/*
 * 81. Search in Rotated Sorted Array II
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * 
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
package com.chang.leetcode;

public class Problem81 {

    public boolean search2(int[] nums, int target) {
        return false;
    }

    public static void main(String[] args) {
        Problem81 problem = new Problem81();
        int[] nums1 = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(true == problem.search(nums1, 0));
        int[] nums2 = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(false == problem.search(nums2, 3));
        int[] nums3 = new int[]{1, 1};
        System.out.println(false == problem.search(nums3, 0));
        int[] nums4 = new int[]{1};
        System.out.println(true == problem.search(nums4, 1));
        int[] nums5 = new int[]{1, 3};
        System.out.println(true == problem.search(nums5, 3));
    }

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
                end--;
            }
        }
        return false;
    }
}
