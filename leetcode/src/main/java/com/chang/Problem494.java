/**
 * 494. Target Sum
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
package com.chang;

public class Problem494 {

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumSub(nums, 0, S);
    }

    private int findTargetSumSub(int[] nums, int start, int left) {
        if(0 == left && start == nums.length) {
            return 1;
        }
        if(start >= nums.length) {
            return 0;
        }

        return findTargetSumSub(nums, start + 1, left - nums[start]) +
                findTargetSumSub(nums, start + 1, left + nums[start]);
    }

    public static void main(String[] args) {
        Problem494 problem = new Problem494();
        int[] nums1 = new int[]{1, 1, 1, 1, 1};
        System.out.println(5 == problem.findTargetSumWaysExample(nums1, 3));
    }

    /**
     * Let P be the positive subset and N be the negative subset
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * <p>
     * So the original problem has been converted to a subset sum problem as follows:
     * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     * <p>
     * Note that the above formula has proved that target + sum(nums) must be even
     * We can use that fact to quickly identify inputs that do not have a solution
     */
     public int findTargetSumWaysExample(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    /**
     * for those who find it hard to understand dp[i] += dp[i - n]
     * try think this way
     * let's start with int[][] dp = new int[nums.length][s + 1] where dp is 2-d array with dp[i][j] means number of ways to get sum j with first i elements from nums.
     * Then you have the transition dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]], i.e. you can get the sum j either by just repeating all the ways to get sum j by using first i-1 elements,
     * or add nums[i] on top of each way to get sum j-nums[i] using first i elements
     * Then you have the dp loop
     */
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

}
