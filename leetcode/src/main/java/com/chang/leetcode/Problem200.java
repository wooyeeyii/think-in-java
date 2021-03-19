/*
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 */
package com.chang.leetcode;

public class Problem200 {

    private int rows = 0;
    private int cols = 0;

    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        if (0 == rows) {
            return count;
        }
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ('1' == grid[i][j]) {
                    count++;
                    setSurroundZero(grid, i, j);
                }
            }
        }
        return count;
    }

    public void setSurroundZero(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        setSurroundZero(grid, i - 1, j);
        setSurroundZero(grid, i + 1, j);
        setSurroundZero(grid, i, j - 1);
        setSurroundZero(grid, i, j + 1);
    }
}


