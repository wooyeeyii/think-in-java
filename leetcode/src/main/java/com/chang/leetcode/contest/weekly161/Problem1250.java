/**
 * 1250. Check If It Is a Good Array
 * <p>
 * Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers.
 * The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
 * <p>
 * Return True if the array is good otherwise return False.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,5,7,23]
 * Output: true
 * Explanation: Pick numbers 5 and 7.
 * 5*3 + 7*(-2) = 1
 * <p>
 * Example 2:
 * Input: nums = [29,6,10]
 * Output: true
 * Explanation: Pick numbers 29, 6 and 10.
 * 29*1 + 6*(-3) + 10*(-1) = 1
 * <p>
 * Example 3:
 * Input: nums = [3,6]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
package com.chang.leetcode.contest.weekly161;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1250 {

    // too slow
    public boolean isGoodArrayTooSlow(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int n : nums) {
                if (set.contains(i - n)) {
                    set.add(i);
                    if (set.contains(i - 1)) {
                        return true;
                    }
                    continue;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem1250 problem = new Problem1250();
        System.out.println(problem.isGoodArray(new int[]{12, 5, 7, 23}));
        System.out.println(problem.isGoodArray(new int[]{29, 6, 10}));
        System.out.println(!problem.isGoodArray(new int[]{3}));
    }

    /**
     * Explanation
     * If a % x = 0 and b % x = 0,
     * appareantly we have (pa + qb) % x == 0
     * If x > 1, making it impossible pa + qb = 1.
     */
    public boolean isGoodArray(int[] A) {
        int x = A[0], y;
        for (int a : A) {
            while (a > 0) {
                y = x % a;
                x = a;
                a = y;
            }
        }
        return x == 1;
    }
}
