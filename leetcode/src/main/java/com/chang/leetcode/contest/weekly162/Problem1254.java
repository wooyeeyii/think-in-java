/*
 * 1254. Number of Closed Islands
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally
 * (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 * Example 1:
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 *
 * Example 2:
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 *
 * Example 3:
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 *
 * Constraints:
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
package com.chang.leetcode.contest.weekly162;

public class Problem1254 {

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

        for (int i : new int[]{0, rows - 1}) {
            for (int j = 0; j < cols; j++) {
                if (0 == grid[i][j]) {
                    setSurroundZero(grid, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j : new int[]{0, cols - 1}) {
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
        Problem1254 problem = new Problem1254();
        int[][] grid1 = new int[][]{
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
        System.out.println(1 == problem.closedIsland(grid3));

        int[][] grid4 = new int[][]{{1}};
        System.out.println(0 == problem.closedIsland(grid4));
    }

}
