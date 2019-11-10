package com.chang.leetcode.contest.weekly162;

public class Problem5257 {

    private int rows = 0;
    private int cols = 0;

    // 找不不靠边的0
    public int closedIsland(int[][] grid) {
        int count = 0;
        rows = grid.length;
        if (0 == rows) {
            return count;
        }
        cols = grid[0].length;

        for (int i : new int[] {0, rows - 1}) {
            for (int j = 0; j < cols; j++) {
                if (0 == grid[i][j]) {
                    setSurroundZero(grid, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j : new int[] {0, cols - 1}) {
                if (0 == grid[i][j]) {
                    setSurroundZero(grid, i, j);
                }
            }
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (0 == grid[i][j]) {
                    count++;
                    setSurroundZero(grid, i, j);
                }
            }
        }

        return count;
    }

    public void setSurroundZero(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        setSurroundZero(grid, i - 1, j);
        setSurroundZero(grid, i + 1, j);
        setSurroundZero(grid, i, j - 1);
        setSurroundZero(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Problem5257 problem = new Problem5257();
        /*int[][] grid1 = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(2 == problem.closedIsland(grid1));

        int[][] grid2 = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(2 == problem.closedIsland(grid2));

        int[][] grid3 = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        System.out.println(1 == problem.closedIsland(grid3));*/

        int[][] grid4 = new int[][]{{1}};
        System.out.println(1 == problem.closedIsland(grid4));
    }

}
