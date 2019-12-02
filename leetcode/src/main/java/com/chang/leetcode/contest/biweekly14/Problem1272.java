/**
 * 1272. Remove Interval
 * <p>
 * Given a sorted list of disjoint intervals, each interval intervals[i] = [a, b]
 * represents the set of real numbers x such that a <= x < b.
 * <p>
 * We remove the intersections between any interval in intervals and the interval toBeRemoved.
 * <p>
 * Return a sorted list of intervals after all such removals.
 * <p>
 * Example 1:
 * Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
 * Output: [[0,1],[6,7]]
 * <p>
 * Example 2:
 * Input: intervals = [[0,5]], toBeRemoved = [2,3]
 * Output: [[0,2],[3,5]]
 * <p>
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * -10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 */
package com.chang.leetcode.contest.biweekly14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1272 {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            result.addAll(remove(interval, toBeRemoved));
        }
        return result;
    }

    private List<List<Integer>> remove(int[] interval, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int left = toBeRemoved[0];
        int right = toBeRemoved[1];
        if (right <= interval[0] || left >= interval[1]) {
            List<Integer> list = new ArrayList<>();
            list.add(interval[0]);
            list.add(interval[1]);
            result.add(list);
        } else if (right > interval[0] && right < interval[1] && left <= interval[0]) {
            List<Integer> list = new ArrayList<>();
            list.add(right);
            list.add(interval[1]);
            result.add(list);
        } else if (left > interval[0] && left < interval[1] && right > interval[0] && right < interval[1]) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(interval[0]);
            list1.add(left);
            result.add(list1);
            List<Integer> list2 = new ArrayList<>();
            list2.add(right);
            list2.add(interval[1]);
            result.add(list2);
        } else if (left > interval[0] && left < interval[1] && right > interval[1]) {
            List<Integer> list = new ArrayList<>();
            list.add(interval[0]);
            list.add(left);
            result.add(list);
        } else {

        }

        return result;
    }

    public static void main(String[] args) {
        Problem1272 problem = new Problem1272();
        int[][] intervals = new int[][]{{0, 2}, {3, 4}, {5, 7}};
        List<List<Integer>> rs1 = problem.removeIntervalExample(intervals, new int[]{1, 6});

        int[][] intervals2 = new int[][]{{0, 5}};
        List<List<Integer>> rs2 = problem.removeIntervalExample(intervals2, new int[]{2, 3});
    }

    public List<List<Integer>> removeIntervalExample(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) { // no overlap.
                ans.add(Arrays.asList(i[0], i[1]));
            } else { // i[1] > toBeRemoved[0] && i[0] < toBeRemoved[1].
                if (i[0] < toBeRemoved[0]) // left end no overlap.
                    ans.add(Arrays.asList(i[0], toBeRemoved[0]));
                if (i[1] > toBeRemoved[1]) // right end no overlap.
                    ans.add(Arrays.asList(toBeRemoved[1], i[1]));
            }
        }
        return ans;
    }

}
