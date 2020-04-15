package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem454 {

    // ExceedTimeLimit
    public int fourSumCountTooSlow(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int d : D) {
            count += threeSumCount(A, B, C, 0 - d);
        }
        return count;
    }

    private int threeSumCount(int[] A, int[] B, int[] C, int sum) {
        int count = 0;
        for (int c : C) {
            count += twoSumCount(A, B, sum - c);
        }
        return count;
    }

    private int twoSumCount(int[] A, int[] B, int sum) {
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                if (a + b == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem454 problem = new Problem454();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(2 == problem.fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int s = a + b;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int n = 0;
        for (int c : C) {
            for (int d : D) {
                int left = 0 - c - d;
                n += map.getOrDefault(left, 0);
            }
        }
        return n;
    }

}
