/*
 * 377. Combination Sum IV
 * 
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem377 {


    public int combinationSum4_1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sumRec(nums, 0, target, new ArrayList<Integer>(), result);
        // 对每个list算可能的排序组合
        return 0;
    }

    private void sumRec(int[] nums, int start, int remain, ArrayList<Integer> list, List<List<Integer>> result) {
        if (0 == remain) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (start >= nums.length) {
            return;
        }

        int mul = remain / nums[start];
        for (int j = 0; j <= mul; j++) {
            int dup = j;
            remain -= nums[start] * j;
            for (int m = 0; m < j; m++) {
                list.add(nums[start]);
            }
            sumRec(nums, start + 1, remain, list, result);
            for (int m = 0; m < j; m++) {
                list.remove(list.size() - 1);
            }
            remain += nums[start] * j;
        }
    }

    public static void main(String[] args) {
        Problem377 problem = new Problem377();

        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(7 == problem.combinationSum4(nums1, 4));

        int[] nums2 = new int[]{3, 1, 2, 4};
        System.out.println(8 == problem.combinationSum4(nums2, 4));
    }


    public int combinationSum4_Rec_Example(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4_Rec_Example(nums, target - nums[i]);
            }
        }
        return res;
    }

    // 上面的递归改进，使用dp保存中间数的结果   up down
    public int combinationSum4_UP_DOWN(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        sumHelper(dp, nums, target);
        return dp[target];
    }

    private int sumHelper(int[] dp, int[] nums, int remain) {
        if (dp[remain] != -1) {
            return dp[remain];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (remain >= nums[i]) {
                res += sumHelper(dp, nums, remain - nums[i]);
            }
        }
        dp[remain] = res;
        return res;
    }

    // DP      bottom up
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }


    /*
     * Time Limit Exceeded when deal with [2, 1, 3] 35
     */
    public int combinationSum4_Detail(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && target >= nums[i]; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            sumRec_2(nums, target - nums[i], list, result);
        }
        return result.size();
    }

    private void sumRec_2(int[] nums, int remain, List<Integer> list, List<List<Integer>> result) {
        if (0 == remain) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            sumRec_2(nums, remain - nums[i], list, result);
            list.remove(list.size() - 1);
        }
    }


}
