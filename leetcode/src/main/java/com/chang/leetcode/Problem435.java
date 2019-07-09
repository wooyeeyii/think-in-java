/**
 * 435. Non-overlapping Intervals
 *
 * Given a collection of intervals, find the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note:
 *     You may assume the interval's end point is always bigger than its start point.
 *     Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 *
 *
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 *
 *
 * Example 2:
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 *
 *
 * Example 3:
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    // 以start排序是错误的
    // [[1,100],[11,22],[1,11],[2,12]]
    public int eraseOverlapIntervalsWrong(int[][] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Problem435 problem = new Problem435();
        int[][] intervals1 = new int[][] {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(1 == problem.eraseOverlapIntervals(intervals1));

        int[][] intervals2 = new int[][] {{1,2}, {1,2}, {1,2}};
        System.out.println(2 == problem.eraseOverlapIntervals(intervals2));

        int[][] intervals3 = new int[][] {{1,2}, {2,3}};
        System.out.println(0 == problem.eraseOverlapIntervals(intervals3));
    }
}
