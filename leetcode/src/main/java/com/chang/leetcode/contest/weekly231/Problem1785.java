package com.chang.leetcode.contest.weekly231;

public class Problem1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long target = goal - sum;
        long cnt = target % limit == 0 ? 0 : 1;
        cnt += Math.abs(target / limit);
        return (int) cnt;
    }

}
