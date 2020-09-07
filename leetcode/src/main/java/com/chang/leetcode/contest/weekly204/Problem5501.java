package com.chang.leetcode.contest.weekly204;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem5501 {

    public int minDays(int[][] grid) {
        Set<Integer> ones = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ones.add(i * grid[0].length + j);
                }
            }
        }
        if (ones.size() == 0) return 0;
        if (ones.size() == 1) return 1;
        if (moreThanOneIsland(grid, ones)) return 0;

        Set<Integer> tmp = new HashSet<>(ones);
        for (int one : ones) {
            tmp.remove(one);
            if (moreThanOneIsland(grid, tmp)) return 1;
            tmp.add(one);
        }
        return 2;
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    //if can't access all island, means more than 2 island, O(K)
    private boolean moreThanOneIsland(int[][] grid, Set<Integer> ones) {
        Queue<Integer> queue = new LinkedList<>();
        int start = ones.iterator().next();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int point = queue.poll();
            visited.add(start);
            int x = point / grid[0].length;
            int y = point % grid[0].length;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    int key = newX * grid[0].length + newY;
                    if (!visited.contains(key) && ones.contains(key)) {
                        visited.add(key);
                        queue.offer(key);
                    }
                }
            }
        }
        return visited.size() < ones.size();
    }

}
