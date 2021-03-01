/**
 *
 */
package com.chang.leetcode.contest.weekly227;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem1755 {

    //-------------------------------------------------
    // recursive
    //-------------------------------------------------
    public int minAbsDifferenceTwoSlow(int[] nums, int goal) {
        return Math.abs(minAbsDifference(nums, 0, goal));
    }

    public int minAbsDifference(int[] nums, int pos, int goal) {
        if (pos == nums.length) {
            return goal;
        }

        int a = minAbsDifference(nums, pos + 1, goal - nums[pos]);
        int b = minAbsDifference(nums, pos + 1, goal);
        return Math.abs(a) >= Math.abs(b) ? b : a;
    }

    public static void main(String[] args) {
        Problem1755 problem = new Problem1755();
        System.out.println(problem.minAbsDifference(new int[]{5, -7, 3, 5}, 6));
        System.out.println(problem.minAbsDifference(new int[]{7, -9, 15, -2}, -5));
        System.out.println(problem.minAbsDifference(new int[]{1, 2, 3}, -7));

    }

    public int minAbsDifference(int[] nums, int goal) {
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        generate(0, nums.length / 2, nums, 0, leftSet);
        generate(nums.length / 2, nums.length, nums, 0, rightSet);
        TreeSet<Integer> ts = new TreeSet<>(rightSet);
        int ans = Math.abs(goal);
        for (int left : leftSet) {
            int right = goal - left;
            if (ts.contains(right)) {
                return 0;
            }
            Integer right1 = ts.lower(right);
            Integer right2 = ts.higher(right);
            if (right1 != null) {
                ans = Math.min(ans, Math.abs(left + right1 - goal));
            }
            if (right2 != null) {
                ans = Math.min(ans, Math.abs(left + right2 - goal));
            }
        }
        return ans;
    }

    private static void generate(int pos, int stop, int[] nums, int sum, Set<Integer> set) {
        if (pos == stop) {
            set.add(sum);
            return;
        }
        generate(pos + 1, stop, nums, sum, set);
        generate(pos + 1, stop, nums, sum + nums[pos], set);
    }

}
