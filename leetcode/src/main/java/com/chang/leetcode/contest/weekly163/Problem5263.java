package com.chang.leetcode.contest.weekly163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5263 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;
        for (int i = 0; i < rows; i++) {
            result.add(Arrays.stream(grid[i]).boxed().collect(Collectors.toList()));
        }

        int rank = k;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int row = (rank % total) / cols;
                int col = (rank % total) % cols;
                result.get(row).set(col, grid[i][j]);
                rank++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem5263 problem = new Problem5263();
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> res1 = problem.shiftGrid(grid1, 1);
    }


}
