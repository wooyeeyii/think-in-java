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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem523 {
































    public boolean checkSubarraySum(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++) {
            list.remove(i);
            int number = list.get(i);
            if(k > number) {
                if(subArraySum(list, k - number)) {

                }
            }
            list.add(i, number);
        }

        return false;
    }

    private boolean subArraySum(List<Integer> list, int i) {
    }


    public static void main(String[] args) {
        Problem523 problem = new Problem523();
        System.out.println(problem.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
        System.out.println(problem.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
    }
}
