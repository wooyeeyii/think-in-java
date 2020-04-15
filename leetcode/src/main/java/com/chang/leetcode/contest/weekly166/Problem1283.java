/**
 * 1283. Find the Smallest Divisor Given a Threshold
 * <p>
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array
 * by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to
 * threshold.
 * Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * It is guaranteed that there will be an answer.
 * <p>
 * Example 1:
 * Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
 * If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
 * <p>
 * Example 2:
 * Input: nums = [2,3,5,7,11], threshold = 11
 * Output: 3
 * <p>
 * Example 3:
 * Input: nums = [19], threshold = 5
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 10^4
 * 1 <= nums[i] <= 10^6
 * nums.length <= threshold <= 10^6
 */
package com.chang.leetcode.contest.weekly166;

public class Problem1283 {

    public int smallestDivisorTooSlow(int[] nums, int threshold) {
        int len = nums.length;
        int maxNum = nums[0];
        for (int i = 0; i < len; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }

        int max = 0;
        int idx = -1;
        for (int i = 1; i <= maxNum; i++) {
            int sum = 0;
            for (int m : nums) {
                sum += m % i == 0 ? m / i : m / i + 1;
            }
            if (sum == threshold) {
                return i;
            }
            if (sum > max && sum <= threshold) {
                max = sum;
                idx = i;
            }
        }

        return idx;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int len = nums.length;
        int maxNum = nums[0];
        for (int m : nums) {
            maxNum = Math.max(maxNum, m);
        }

        int max = 0;
        int idx = -1;
        int left = 1;
        while (maxNum >= left) {
            int divisor = (left + maxNum) / 2;
            int sum = 0;
            for (int m : nums) {
                sum += m % divisor == 0 ? m / divisor : m / divisor + 1;
            }

            if (sum > threshold) {
                left = divisor + 1;
            } else {
                if (sum > max) {
                    max = sum;
                    idx = divisor;
                } else if (sum == max && -1 != idx) {
                    idx = Math.min(idx, divisor);
                }
                maxNum = divisor - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        Problem1283 problem = new Problem1283();
        System.out.println(5 == problem.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(3 == problem.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(4 == problem.smallestDivisor(new int[]{19}, 5));
    }

    public int smallestDivisorExample(int[] A, int threshold) {
        int left = 1, right = (int) 1e6;
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : A)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }

}
