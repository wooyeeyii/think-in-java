package com.chang.leetcode.contest.weekly195;

import java.util.Arrays;

public class Problem1497 {

    public boolean canArrange(int[] arr, int k) {
        int sum = 0;
        int[] lefts = new int[k];
        Arrays.fill(lefts, 0);
        for (int n : arr) {
            int l = n % k;
            l = l < 0 ? l + k : l;

            lefts[l] += 1;
            sum = (sum + l) % k;
        }

        if (0 != sum) {
            return false;
        }

        for (int i = 1, j = k - 1; i < j; i++, j--) {
            if (lefts[i] != lefts[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1497 problem = new Problem1497();
        System.out.println(problem.canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println(problem.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
        System.out.println(problem.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 10));
        System.out.println(problem.canArrange(new int[]{-10, 10}, 2));
        System.out.println(problem.canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));
    }

}
