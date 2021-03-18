package com.chang.leetcode.contest.weekly230;

public class Problem1774 {

    int result;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = baseCosts[0];
        for (int base : baseCosts)
            helper(base, toppingCosts, 0, target);
        return result;
    }

    private void helper(int current, int[] toppingCosts, int index, int target) {
        if (Math.abs(target - current) < Math.abs(target - result) || (Math.abs(target - current) == Math.abs(target - result) && current < result))
            result = current;
        if (index == toppingCosts.length || current >= target) return;
        helper(current, toppingCosts, index + 1, target);
        helper(current + toppingCosts[index], toppingCosts, index + 1, target);
        helper(current + toppingCosts[index] * 2, toppingCosts, index + 1, target);
    }

}
