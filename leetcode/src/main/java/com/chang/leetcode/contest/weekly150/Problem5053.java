package com.chang.leetcode.contest.weekly150;

import java.util.ArrayList;
import java.util.List;

public class Problem5053 {

    public int maxDistance(int[][] grid) {
        List<int[]> lands = new ArrayList<>();
        int len = grid.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(1 == grid[i][j]) {
                    count++;
                    lands.add(new int[] {i, j});
                }
            }
        }

        if(0 == count) {
            return -1;
        }

        int max = -1;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(0 == grid[i][j]) {
                    int min = Integer.MAX_VALUE;
                    for(int[] l : lands) {
                        int dis = Math.abs(l[0]-i) + Math.abs(l[1]- j);
                        if(dis < min) {
                            min = dis;
                        }
                    }

                    if(min > max) {
                        max = min;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem5053 problem = new Problem5053();
        int[][] grid1 = new int[][] {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(2 == problem.maxDistance(grid1));

        int[][] grid2 = new int[][] {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(4 == problem.maxDistance(grid2));

        int[][] grid3 = new int[][] {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        System.out.println(-1 == problem.maxDistance(grid3));

    }

}
