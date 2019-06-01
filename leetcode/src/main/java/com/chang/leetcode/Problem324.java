/**
 * 324. Wiggle Sort II
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 *
 * Example 2:
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem324 {

    // 不可行，处理不了中间出现重复数字的情况
    public void wiggleSortWrong(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int start = 1;
        int end = (len % 2 == 0 ? len - 2 : len - 1);
        while(start < end) {
            swap(nums, start, end);
            start += 2;
            end -= 2;
        }

        if(0 == len % 2) {
            int mid = len / 2;
            if(nums[mid] == nums[mid - 1]) {
                swap(nums, mid - 2, mid );
                swap(nums, mid - 1, mid + 1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        Problem324 problem = new Problem324();
        int[] nums1 = new int[] {1, 5, 1, 1, 6, 4};
        problem.wiggleSort(nums1);
        printArray(nums1);

        int[] nums2 = new int[] {1, 3, 2, 2, 3, 1};
        problem.wiggleSort(nums2);
        printArray(nums2);

        int[] nums3 = new int[] {1, 5, 1, 1, 6, 4, 7};
        problem.wiggleSort(nums3);
        printArray(nums3);

        int[] nums4 = new int[] {4, 5, 5, 6};
        problem.wiggleSort(nums4);
        printArray(nums4);
    }

    private static void printArray(int[] nums) {
        for(int s : nums) {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("#############");
    }

    /**
     * 先排序，从中间开始
     * 小于中间的数倒叙 依次插入到奇数位置上
     * 大于中间的数倒叙 依次插入到偶数的位置上
     * 4 5 5 5 5 6 6 6
     *       中
     * 5   5   5   4
     *   6   6   6   5
     */
    public void wiggleSort(int[] nums) {
        int[] sort = nums.clone();
        Arrays.sort(sort);
        for(int i=(sort.length-1)/2, j=0; i>=0; i--, j+=2) nums[j]=sort[i];
        for(int i=sort.length-1, j=1; i>(sort.length-1)/2; i--, j+=2) nums[j]=sort[i];
    }

    // 改进，不需要排序，找到中位数，区分大于它的和小于他的就可以了
    public void wiggleSortImpro(int[] nums) {

    }

}
