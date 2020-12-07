/**
 * 1658. Minimum Operations to Reduce X to Zero
 *
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 *
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 *
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 *
 * Example 3:
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
package com.chang.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Problem1658 {

    // Time Limit Exceed
    public int minOperationsTooSlow(int[] nums, int x) {
        int n = minOperationsCur(nums, 0, nums.length - 1, x);
        return Integer.MAX_VALUE == n ? -1 : n;
    }

    private int minOperationsCur(int[] nums, int start, int end, int x) {
        if (start > end || x < 0) {
            return Integer.MAX_VALUE;
        }

        if (x == nums[start] || x == nums[end]) {
            return 1;
        }

        int left = minOperationsCur(nums, start + 1, end, x - nums[start]);
        int right = minOperationsCur(nums, start, end - 1, x - nums[end]);
        int min = Math.min(left, right);
        if (Integer.MAX_VALUE == min) {
            return Integer.MAX_VALUE;
        } else {
            return min + 1;
        }
    }


    public int minOperationsOriginal(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Map<Integer, Integer> fromLeft = new HashMap<>();
        fromLeft.put(0, -1);
        Map<Integer, Integer> fromRight = new HashMap<>();
        fromRight.put(0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            fromLeft.put(sum, i);
        }
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            fromRight.put(sum, i);
        }

        for (Map.Entry<Integer, Integer> e : fromLeft.entrySet()) {
            if (fromRight.containsKey(x - e.getKey()) && fromRight.get(x - e.getKey()) > e.getValue()) {
                min = Math.min(min, e.getValue() + 1 + nums.length - fromRight.get(x - e.getKey()));
            }
        }

        for (Map.Entry<Integer, Integer> e : fromRight.entrySet()) {
            if (fromLeft.containsKey(x - e.getKey()) && fromLeft.get(x - e.getKey()) < e.getValue()) {
                min = Math.min(min, fromLeft.get(x - e.getKey()) + 1 + nums.length - e.getValue());
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Problem1658 problem = new Problem1658();
        System.out.println(problem.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }

    // another idea. longest sub array in the middle which's sum is target -x.
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int n : nums) {
            target += n;
        }

        if (0 == target) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                max = Math.max(max, i - map.get(sum - target));
            }

            map.put(sum, i);
        }
        return max == -1 ? -1 : nums.length - max;
    }


}
