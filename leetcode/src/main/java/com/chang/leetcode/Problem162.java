/**
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 *
 * The array may contain multiple peaks, in that case return the index
 * to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 *
 * Note:
 * Your solution should be in logarithmic complexity.
 */
package com.chang.leetcode;

public class Problem162 {

    public int findPeakElement(int[] nums) {
        for(int i = 1; i <= nums.length - 2; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int findPeakElementLogarithmic(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while(low < high) {
            int mid1 = low + (high - low) /2 ;
            int mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }

    public static void main(String[] args) {
        Problem162 problem = new Problem162();
        int[] nums1 = new int[] {1,2,3,1};
        System.out.println(problem.findPeakElementLogarithmic(nums1));
        int[] nums2 = new int[] {1,2,1,3,5,6,4};
        System.out.println(problem.findPeakElementLogarithmic(nums2));
    }
}
