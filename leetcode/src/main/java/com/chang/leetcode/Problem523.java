/**
 * 523. Continuous Subarray Sum
 *
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array
 * has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
 *
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 *
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {

    public static void main(String[] args) {
        Problem523 problem = new Problem523();
        System.out.println(problem.checkSubarraySumExample(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(problem.checkSubarraySumExample(new int[]{23, 2, 4, 6, 7}, 6));
    }

    // We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process.
    // If we find that a running sum value at index j has been previously seen before in some earlier index i in the array,
    // then we know that the sub-array (i,j] contains a desired sum.
    public boolean checkSubarraySumExample(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            if(0 != k) {
                left = left % k;
            }
            if(map.containsKey(left)) {
                if( i - map.get(left) > 1) {
                    return true;
                }
            } else {
                map.put(left, i);
            }
        }
        return false;
    }
}
