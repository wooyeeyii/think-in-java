package com.chang.leetcode.contest.weekly204;

import java.util.Arrays;

public class Problem5499 {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length - m; i++) {
            if (containsPattern(arr, i, m, k)) {
                return true;
            }
        }

        return false;
    }

    private boolean containsPattern(int[] arr, int start, int m, int k) {
        if (m * k > arr.length - start) {
            return false;
        }

        int[] target = Arrays.copyOfRange(arr, start, m + start);
        int cnt = 1;
        for (int i = m + start; i < arr.length; i += m) {
            for (int j = 0; j < m; j++) {
                if (arr[i + j] != target[j]) {
                    return false;
                }
            }
            cnt++;
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem5499 problem = new Problem5499();
        System.out.println(problem.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        System.out.println(problem.containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        System.out.println(problem.containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
        System.out.println(problem.containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(problem.containsPattern(new int[]{2, 2, 2, 2}, 2, 3));
    }

    public boolean containsPatternExample(int[] arr, int m, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0, j = i + m; j < n; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }

}
