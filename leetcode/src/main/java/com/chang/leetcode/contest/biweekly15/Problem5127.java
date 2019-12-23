package com.chang.leetcode.contest.biweekly15;

import java.util.*;

public class Problem5127 {

    public int removeCoveredIntervals(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] interval : intervals) {
            if(!map.containsKey(interval[0]) || map.get(interval[0]) < interval[1]) {
                map.put(interval[0], interval[1]);
            }
        }

        List<int[]> list = new ArrayList<>();
        map.forEach((k, v) -> {
            list.add(new int[] {k, v});
        });
        list.sort((a, b) -> a[0] - b[0]);

        int i = 0;
        while(i < list.size()) {
            int[] start = list.get(i);
            int j = i + 1;
            while(j < list.size()) {
                if(start[1] >= list.get(j)[1]) {
                    list.remove(j);
                } else {
                    j++;
                }
            }
            i++;
        }

        return list.size();
    }

    public static void main(String[] args) {
        Problem5127 problem = new Problem5127();
        System.out.println(2 == problem.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {3, 6}, {2, 8}}));
        System.out.println(2 == problem.removeCoveredIntervals(new int[][]{{1, 4}, {2, 4}, {3, 4}, {6, 8}}));
    }

}
