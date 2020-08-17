package com.chang.leetcode.contest.weekly202;

import java.util.Arrays;

public class Problem5489 {

    // 二分查找的边界判断，耽误了很久
    public int maxDistance1(int[] position, int m) {
        int len = position.length;
        Arrays.sort(position);
        int low = 1, high = (position[len - 1] - position[0]) / (m - 1);
        int max = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (fit(position, m, mid)) {
                max = Math.max(max, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return max;
    }

    private boolean fit(int[] position, int m, int k) {
        int pre = position[0];
        m--;
        for (int n : position) {
            if (n - pre >= k) {
                m--;
                pre = n;

                if (m <= 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem5489 problem = new Problem5489();
        System.out.println(problem.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(problem.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(problem.maxDistance(new int[]{79, 74, 57, 22}, 4));
    }

    public int maxDistance(int[] position, int m) {
        int len = position.length;
        Arrays.sort(position);
        int low = 1, high = (position[len - 1] - position[0]) / (m - 1);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (fit(position, m, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
