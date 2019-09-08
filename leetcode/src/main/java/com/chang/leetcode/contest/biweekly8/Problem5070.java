package com.chang.leetcode.contest.biweekly8;

import java.util.ArrayList;
import java.util.List;

public class Problem5070 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer>[] pos = new List[3];
        for (int i = 0; i < 3; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < colors.length; i++) {
            pos[colors[i] - 1].add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            if (colors[query[0]] == query[1]) {
                result.add(0);
            } else {
                result.add(find(query[0], pos[query[1] - 1]));
            }
        }
        return result;
    }

    private int find(int idx, List<Integer> flag) {
        int diff = -1;
        if (null == flag || flag.size() == 0) {
            return diff;
        }

        int left = 0;
        int right = flag.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (flag.get(mid) > idx) {
                right = mid - 1;
            } else if (flag.get(mid) < idx) {
                left = mid + 1;
            } else {
                return 0;
            }
        }
        int a = Math.abs(idx - flag.get(left));
        int b = right >= 0 ? Math.abs(idx - flag.get(right)) : Integer.MAX_VALUE;
        int c = (left + 1) < flag.size() ? Math.abs(idx - flag.get(left + 1)) : Integer.MAX_VALUE;
        int d = (right - 1) >= 0 ? Math.abs(idx - flag.get(right - 1)) : Integer.MAX_VALUE;
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public static void main(String[] args) {
        Problem5070 problem = new Problem5070();
        int[] colors1 = new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries1 = new int[][]{{1, 3}, {2, 2}, {6, 1}};
        List<Integer> res1 = problem.shortestDistanceColor(colors1, queries1);

        int[] colors2 = new int[]{1, 2};
        int[][] queries2 = new int[][]{{0, 3}};
        List<Integer> res2 = problem.shortestDistanceColor(colors2, queries2);


        int[] colors3 = new int[]{3, 1, 1, 2, 3, 3, 2, 1, 2, 3, 1, 1, 3, 2, 3, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 3, 3, 3, 1, 3, 2, 1, 1, 2, 2, 1, 3, 1, 2, 1, 1, 2, 2, 1, 2};
        int[][] queries3 = new int[][]{{38, 1}};
        List<Integer> res3 = problem.shortestDistanceColor(colors3, queries3);
    }
}
