/**
 * 503. Next Greater Element II
 * <p>
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number
 * to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem503 {

    public int[] nextGreaterElements(int[] nums) {
        if (null == nums) {
            return null;
        }
        int len = nums.length;
        int[] result = new int[len];

        for (int idx = 0; idx < len; idx++) {
            int i = 0;
            for (; i < len; i++) {
                if (nums[(idx + i) % len] > nums[idx]) {
                    result[idx] = nums[(idx + i) % len];
                    break;
                }
            }
            if (i == len) {
                result[idx] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem503 problem = new Problem503();
        int[] nums1 = new int[]{1, 2, 1};
        int[] res = problem.nextGreaterElements(nums1);
    }

    public int[] nextGreaterElementsExample(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }
}
