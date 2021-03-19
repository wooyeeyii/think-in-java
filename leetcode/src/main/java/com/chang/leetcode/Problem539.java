/*
 * 539. Minimum Time Difference
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 *
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem539 {

    // 需要排序
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            String[] parts = timePoints.get(i).split(":");
            times[i] = Integer.valueOf(parts[0]) * 60 + Integer.valueOf(parts[1]);
        }

        Arrays.sort(times);
        int min = times[0] + 24 * 60 - times[len - 1];
        for (int i = 1; i < len; i++) {
            if (times[i] - times[i - 1] < min) {
                min = times[i] - times[i - 1];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Problem539 problem = new Problem539();
        List<String> list1 = new ArrayList<>();
        list1.add("23:59");
        list1.add("00:00");
        System.out.println(1 == problem.findMinDifference(list1));
    }

    // int[] recored = new int[24 * 60]
    //

}
