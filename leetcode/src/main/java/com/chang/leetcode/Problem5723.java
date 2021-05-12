package com.chang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem5723 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] result = new int[k];
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.put(log[0], set);
        }

        map.forEach((key, value) -> {
            if (value.size() >= 1 && value.size() <= k) {
                result[value.size() - 1]++;
            }
        });

        return result;
    }

    public static void main(String[] args) {
        Problem5723 problem = new Problem5723();
        int[] res1 = problem.findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
    }

}
