package com.chang.leetcode.math;

import java.util.Arrays;

public class Problem1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unit = 0, i = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        while (truckSize > 0 && i < boxTypes.length) {
            int min = Math.min(truckSize, boxTypes[i][0]);
            unit += min * boxTypes[i][1];
            truckSize -= min;
            i++;
        }

        return unit;
    }

    public static void main(String[] args) {
        Problem1710 problem = new Problem1710();
        // 8
        System.out.println(problem.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        // 91
        System.out.println(problem.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        //
        System.out.println(problem.maximumUnits(new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 33));
    }

}
