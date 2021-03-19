/*
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
package com.chang.leetcode;

public class Problem581 {

    public int findUnsortedSubarrayMy(int[] nums) {
        if (null == nums || 1 == nums.length) {
            return 0;
        }

        int[] maxDp = new int[nums.length];
        maxDp[0] = 0;
        int[] minDp = new int[nums.length];
        minDp[nums.length - 1] = nums.length - 1;

        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = nums[i] >= nums[maxDp[i - 1]] ? i : maxDp[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxDp[i] != i) {
                right = i;
                break;
            }
        }

        int left = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            minDp[i] = nums[i] <= nums[minDp[i + 1]] ? i : minDp[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (minDp[i] != i) {
                left = i;
                break;
            }
        }

        return left < right ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        Problem581 problem = new Problem581();
        System.out.println(5 == problem.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(0 == problem.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(2 == problem.findUnsortedSubarray(new int[]{2, 1}));
        System.out.println(0 == problem.findUnsortedSubarray(new int[]{1, 2, 3, 3, 3}));
    }

    // 依次找最大值max，若后面某位x的值A[x] < max, 则x之前的数就要考虑重排了
    // 倒序找最小值min, 若前面某位y的值A[y] > min, 则y之后的数就要考虑重排了
    public int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);
            if (A[i] < max) end = i;
            if (A[n - 1 - i] > min) beg = n - 1 - i;
        }
        return end - beg + 1;
    }

}
