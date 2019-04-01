/**
 * 16. 3Sum Closest
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums
 * such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {

    private int cloest = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        nSumClosest(list, target, 3);
        return target - cloest;
    }

    // 全部遍历，时间超时, 且有重复利用数字的嫌疑
    // 前面用过的数字就不再使用了
    private void nSumClosest(List<Integer> list, int left, int count) {
        if(null == list && count != 0) {
            return;
        }
        if (0 == count) {
            if (Math.abs(left) < Math.abs(cloest)) {
                cloest = left;
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            List<Integer> subList = null;
            if(i + 1 < list.size()) {
                subList = list.subList(i + 1, list.size());
            }
            nSumClosest(subList, left - n, count - 1);
        }
    }

    public static void main(String[] args) {
        Problem16 problem = new Problem16();
        int[] nums = new int[]{-1, 2, 1, -4};
        //System.out.println(2 == problem.threeSumClosest(nums, 1));
        System.out.println(0 == problem.threeSumClosest(new int[] {0, 0, 0}, 1));
    }
}
