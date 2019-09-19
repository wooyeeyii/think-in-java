/**
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
package com.chang.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    public int subarraySum(int[] nums, int k) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int len = nums.length;
        int[] clockwiseSum = new int[len + 1];
        clockwiseSum[0] = nums[0];
        for (int i = 0; i < len; i++) {
            clockwiseSum[i + 1] = clockwiseSum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (clockwiseSum[j + 1] - clockwiseSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem560 problem = new Problem560();
        System.out.println(2 == problem.subarraySum(new int[]{1, 1, 1}, 2));
    }

    /**
     * Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.
     *
     * Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j],
     * then we can easily get SUM[i, j]. To achieve this, we just need to go through the array,
     * calculate the current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
     */
    public int subarraySumExample(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

}
