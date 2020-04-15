package com.chang.leetcode.contest.weekly150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1162 {

    // brute force solution
    public int maxDistanceTooSlow(int[][] grid) {
        List<int[]> lands = new ArrayList<>();
        int len = grid.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (1 == grid[i][j]) {
                    count++;
                    lands.add(new int[]{i, j});
                }
            }
        }

        if (0 == count) {
            return -1;
        }

        int max = -1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (0 == grid[i][j]) {
                    int min = Integer.MAX_VALUE;
                    for (int[] l : lands) {
                        int dis = Math.abs(l[0] - i) + Math.abs(l[1] - j);
                        if (dis < min) {
                            min = dis;
                        }
                    }

                    if (min > max) {
                        max = min;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem1162 problem = new Problem1162();
        int[][] grid1 = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(2 == problem.maxDistance(grid1));

        int[][] grid2 = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(4 == problem.maxDistance(grid2));

        int[][] grid3 = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(-1 == problem.maxDistance(grid3));

    }

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) continue;
                bfs(grid, i, j);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) continue;
                if (grid[i][j] == 0) return -1;
                res = Math.max(grid[i][j], res);
            }
        }
        return res == 0 ? -1 : res;
    }

    private void bfs(int[][] grid, int r0, int c0) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(r0 * n + c0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            int x = curr / n, y = curr % n;
            // System.out.println(x + "," + y);
            for (int[] dir : dirs) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1) continue;
                int dist = grid[x][y] == -1 ? 1 : grid[x][y] + 1;
                if (grid[r][c] == 0 || grid[r][c] > dist) {
                    // System.out.println(r + "," + c);
                    grid[r][c] = dist;
                    q.offer(r * n + c);
                }
            }
        }
    }

}
