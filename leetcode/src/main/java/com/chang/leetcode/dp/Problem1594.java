/*
 * 1594. Maximum Non Negative Product in a Matrix
 *
 * You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0),
 * and in each step, you can only move right or down in the matrix.
 * Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1),
 * find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
 *
 * Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.
 * Notice that the modulo is performed after getting the maximum product.
 *
 * Example 1:
 * Input: grid = [[-1,-2,-3],
 *                [-2,-3,-3],
 *                [-3,-3,-2]]
 * Output: -1
 * Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
 *
 * Example 2:
 * Input: grid = [[1,-2,1],
 *                [1,-2,1],
 *                [3,-4,1]]
 * Output: 8
 * Explanation: Maximum non-negative product is in bold (1 * 1 * -2 * -4 * 1 = 8).
 *
 * Example 3:
 * Input: grid = [[1, 3],
 *                [0,-4]]
 * Output: 0
 * Explanation: Maximum non-negative product is in bold (1 * 0 * -4 = 0).
 *
 * Example 4:
 * Input: grid = [[ 1, 4,4,0],
 *                [-2, 0,0,1],
 *                [ 1,-1,1,1]]
 * Output: 2
 * Explanation: Maximum non-negative product is in bold (1 * -2 * 1 * -1 * 1 * 1 = 2).
 *
 * Constraints:
 *
 * 1 <= rows, cols <= 15
 * -4 <= grid[i][j] <= 4
 *
 */
package com.chang.leetcode.dp;

public class Problem1594 {

    int mod = 1000000007;
    long product = -1;

    public int maxProductPath(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return (int) (product % mod);
    }

    public void dfs(int[][] grid, int i, int j, long curr) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            product = Math.max(product, curr);
            return;
        }
        if (grid[i][j] == 0) {
            product = Math.max(product, 0);
            return;
        }
        if (i + 1 < grid.length)
            dfs(grid, i + 1, j, curr * grid[i + 1][j]);
        if (j + 1 < grid[0].length)
            dfs(grid, i, j + 1, curr * grid[i][j + 1]);
    }

    /**********************************
     * DP
     **********************************/

    //define a Pair object to store min and max path product at every cell in the grid
    class Pair {
        Long min;
        Long max;

        Pair(Long min, Long max) {
            this.min = min;
            this.max = max;
        }
    }

    public int maxProductPathDp(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int r = grid.length;
        int c = grid[0].length;
        int mod = 1000000007;

        Pair[][] dp = new Pair[r][c];

        //initialize first cell as (grid[0][0],grid[0][0]) since min and max are the same here
        dp[0][0] = new Pair((long) grid[0][0], (long) grid[0][0]);

        //initialize first row, min=max= prev row product* grid[i][j]
        for (int i = 1; i < r; i++)
            dp[i][0] = new Pair(dp[i - 1][0].min * grid[i][0], dp[i - 1][0].max * grid[i][0]);

        //initialize first column, min=max= prev col product* grid[i][j]
        for (int j = 1; j < c; j++)
            dp[0][j] = new Pair(dp[0][j - 1].min * grid[0][j], dp[0][j - 1].max * grid[0][j]);

        //from grid[1][1] to grid[r][c]
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                long min = grid[i][j] * Math.min(dp[i - 1][j].min, dp[i][j - 1].min);
                long max = grid[i][j] * Math.max(dp[i - 1][j].max, dp[i][j - 1].max);
                dp[i][j] = new Pair(Math.min(min, max), Math.max(min, max));
            }
        }
        return dp[r - 1][c - 1].max < 0 ? -1 : (int) (dp[r - 1][c - 1].max % mod);
    }


}
