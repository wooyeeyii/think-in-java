/*
 * 757. Set Intersection Size At Least Two
 *
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
 *
 * Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has a size of at least two.
 *
 * Example 1:
 * Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
 * Output: 3
 * Explanation: Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 * Also, there isn't a smaller size set that fulfills the above condition.
 * Thus, we output the size of this set, which is 3.
 *
 * Example 2:
 * Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
 * Output: 5
 * Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
 *
 * Constraints:
 * 1 <= intervals.length <= 3000
 * intervals[i].length == 2
 * 0 <= ai < bi <= 108
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem757 {

    // Time Limit Exceed
    public int intersectionSizeTwoTooSlow(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        Set<Integer> set = new HashSet<>();
        set.add(intervals[0][1]);
        set.add(intervals[0][1] - 1);
        for (int i = 1; i < intervals.length; i++) {
            int[] in = intervals[i];
            int[] pre = intervals[i - 1];
            if (in[0] <= pre[0]) {
                continue;
            } else if (in[0] > pre[1]) {
                set.add(in[1]);
                set.add(in[1] - 1);
            } else {
                int cnt = 0;
                for (int j = in[0]; j <= pre[1]; j++) {
                    if (set.contains(j)) {
                        cnt++;
                    }
                }
                if (0 == cnt) {
                    set.add(in[1]);
                    set.add(in[1] - 1);
                } else if (1 == cnt) {
                    set.add(in[1]);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Problem757 problem = new Problem757();
        System.out.println(problem.intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {5, 7}, {7, 8}}));
        System.out.println(problem.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println(problem.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int cnt = 0, max = -1, sedMax = -1;
        for (int[] in : intervals) {
            if (in[0] <= sedMax) {
                continue;
            } else if (in[0] <= max) {
                cnt++;
                sedMax = max;
                max = in[1];
            } else {
                cnt += 2;
                max = in[1];
                sedMax = in[1] - 1;
            }
        }
        return cnt;
    }

}
