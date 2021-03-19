/*
 * 24 Game
 *
 * You have 4 cards each containing a number from 1 to 9.
 * You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 *
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 *
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem679 {

    final double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (1 == list.size()) {
            if (Math.abs(list.get(0) - 24.0) < eps) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                double p1 = list.get(i);
                double p2 = list.get(j);
                List<Double> nextRound = new ArrayList<Double>();
                nextRound.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));
                if (Math.abs(p1 - eps) > 0) {
                    nextRound.add(p2 / p1);
                }
                if (Math.abs(p2 - eps) > 0) {
                    nextRound.add(p1 / p2);
                }

                //移除的顺序不要颠倒
                list.remove(i);
                list.remove(j);
                for (Double n : nextRound) {
                    list.add(n);
                    if (dfs(list)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
                //添加的顺序不要颠倒
                list.add(j, p2);
                list.add(i, p1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem679 problem = new Problem679();
        int[] nums1 = new int[]{4, 1, 8, 7};
        System.out.println(problem.judgePoint24(nums1));
        int[] nums2 = new int[]{1, 2, 1, 2};
        System.out.println(problem.judgePoint24(nums2));
    }

}
