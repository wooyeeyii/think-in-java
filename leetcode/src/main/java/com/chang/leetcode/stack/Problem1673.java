/**
 * 1673. Find the Most Competitive Subsequence
 * <p>
 * Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
 * An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
 * We define that a subsequence a is more competitive than a subsequence b (of the same length)
 * if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b.
 * For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.
 * <p>
 * Example 1:
 * Input: nums = [3,5,2,6], k = 2
 * Output: [2,6]
 * Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
 * <p>
 * Example 2:
 * Input: nums = [2,4,3,3,5,4,9,6], k = 4
 * Output: [2,3,3,4]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 */
package com.chang.leetcode.stack;

import java.util.Stack;

public class Problem1673 {

    public int[] mostCompetitiveTooSlow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];
        int start = 0;
        for (int i = 0; i < k; i++) {
            int[] numberAndPos = findMin(nums, start, len - k + i);
            start = numberAndPos[1] + 1;
            res[i] = numberAndPos[0];
        }
        return res;
    }

    private int[] findMin(int[] nums, int start, int end) {
        int min = nums[start];
        int idx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }
        }
        return new int[]{min, idx};
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1673 problem = new Problem1673();
//        int[] res1 = problem.mostCompetitive(new int[]{3, 5, 2, 6}, 2);
        int[] res2 = problem.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
    }

}
