package com.chang.leetcode.contest.weekly201;

import java.util.HashMap;
import java.util.Map;

public class Problem5471 {

    // Time Limit Exceed
    public int maxNonOverlappingSlow(int[] nums, int target) {
        int max = 0;
        int last = -1;
        int[] dp = new int[nums.length];
        dp[0] = target == nums[0] ? 1 : 0;
        last = target == nums[0] ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            for (int k = i; k > last; k--) {
                sum += nums[k];
                if (target == sum) {
                    break;
                }
            }
            dp[i] = target == sum ? (last >= 0 ? dp[last] + 1 : 1) : 0;
            last = 0 == dp[i] ? last : i;
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem5471 problem = new Problem5471();
        System.out.println(problem.maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, last = -1;
        map.put(0, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain) >= last) {
                cnt++;
                last = i;
            }
            map.put(prefixSum, i);
        }

        return cnt;
    }

}
