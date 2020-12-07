/**
 * 1664. Ways to Make a Fair Array
 * <p>
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element.
 * Notice that the index of the elements may change after the removal.
 * <p>
 * For example, if nums = [6,1,7,4,1]:
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 * <p>
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 * <p>
 * Example 1:
 * Input: nums = [2,1,6,4]
 * Output: 1
 * Explanation:
 * Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
 * Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
 * Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
 * Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
 * There is 1 index that you can remove to make nums fair.
 * <p>
 * Example 2:
 * Input: nums = [1,1,1]
 * Output: 3
 * Explanation: You can remove any index and the remaining array is fair.
 * <p>
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: You cannot make a fair array after removing any index.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
package com.chang.leetcode.string;

public class Problem5607 {

    public int waysToMakeFairTooComplicated(int[] nums) {
        int len = nums.length;
        if (1 == len) {
            return 1;
        }
        if (2 == len) {
            return 0;
        }

        int[][] leftSum = new int[len][2];

        leftSum[0][0] = nums[0];
        leftSum[0][1] = 0;
        leftSum[1][0] = nums[0];
        leftSum[1][1] = nums[1];
        for (int i = 2; i < len; i++) {
            if (i % 2 == 1) {
                leftSum[i][1] = leftSum[i - 2][1] + nums[i];
                leftSum[i][0] = leftSum[i - 1][0];
            } else {
                leftSum[i][0] = leftSum[i - 2][0] + nums[i];
                leftSum[i][1] = leftSum[i - 1][1];
            }
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int a = (i == 0 ? 0 : leftSum[i - 1][0]) + leftSum[len - 1][1] - leftSum[i][1];
            int b = (i == 0 ? 0 : leftSum[i - 1][1]) + leftSum[len - 1][0] - leftSum[i][0];
            if (a == b) {
                cnt++;
            }
        }

        return cnt;
    }

    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int rightOdd = 0, rightEven = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                rightOdd += nums[i];
            } else {
                rightEven += nums[i];
            }
        }

        int leftOdd = 0, leftEven = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                rightOdd -= nums[i];
            } else {
                rightEven -= nums[i];
            }

            if (leftOdd + rightEven == leftEven + rightOdd) {
                cnt++;
            }

            if (i % 2 == 0) {
                leftOdd += nums[i];
            } else {
                leftEven += nums[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem5607 problem = new Problem5607();
        System.out.println(problem.waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(problem.waysToMakeFair(new int[]{1, 2, 3}));
    }

}
