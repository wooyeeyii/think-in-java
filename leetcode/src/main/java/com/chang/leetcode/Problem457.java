/*
 * 457. Circular Array Loop
 *
 * You are given a circular array nums of positive and negative integers. If a number k at an index is positive,
 * then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular,
 * you may assume that the last element's next element is the first element,
 * and the first element's previous element is the last element.
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1.
 * Furthermore, movements in a cycle must all follow a single direction.
 * In other words, a cycle must not consist of both forward and backward movements.
 *
 * Example 1:
 * Input: [2,-1,1,2,2]
 * Output: true
 * Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
 *
 * Example 2:
 * Input: [-1,2]
 * Output: false
 * Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1.
 * By definition the cycle's length must be greater than 1.
 *
 * Example 3:
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 * Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement,
 * but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.
 *
 * Note:
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 1 ≤ nums.length ≤ 5000
 */
package com.chang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem457 {

    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            if (beginCircle(i, nums, used)) {
                return true;
            }
        }
        return false;
    }

    private boolean beginCircle(int i, int[] nums, boolean[] used) {
        Set<Integer> set = new HashSet<>();
        int positive = nums[i] > 0 ? 1 : -1;

        int next = i;
        while (set.add(next)) {
            if (used[next] || positive * nums[next] < 0) {
                return false;
            }

            used[next] = true;
            int n = (next + nums[next]) < 0 ? ((next + nums[next]) % nums.length + nums.length) : ((next + nums[next]) % nums.length);
            if (n == next) return false;
            next = n;
        }

        return set.size() > 1;
    }

    public static void main(String[] args) {
        Problem457 problem = new Problem457();

        int[] nums1 = new int[]{2, -1, 1, 2, 2};
        System.out.println(problem.circularArrayLoop(nums1));

        int[] nums2 = new int[]{-1, 2};
        System.out.println(!problem.circularArrayLoop(nums2));

        int[] nums3 = new int[]{-2, 1, -1, -2, -2};
        System.out.println(!problem.circularArrayLoop(nums3));

        int[] nums4 = new int[]{-8, -1, 1, 7, 2};
        System.out.println(!problem.circularArrayLoop(nums4));

        int[] nums5 = new int[]{-1};
        System.out.println(!problem.circularArrayLoop(nums5));

        int[] nums6 = new int[]{-1, -2, -3, -4, -5};
        System.out.println(!problem.circularArrayLoop(nums6));
    }

}
