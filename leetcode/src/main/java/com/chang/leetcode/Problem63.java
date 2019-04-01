/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
package com.chang.leetcode;

public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = 0;
        if(0 == rows || 0 == (cols = obstacleGrid[0].length)) {
            return 0;
        }
        int[] record = new int[cols];
        for(int i = 0; i < cols; i++) {
            if(1 == obstacleGrid[0][i]) {
                record[i] = 0;
                while(++i < cols) {
                    record[i] = 0;
                }
            } else {
                record[i] = 1;
            }
        }

        for(int i = 1; i < rows; i++) {
            if(0 == obstacleGrid[i][0] && 1 == record[0]) {
                record[0] = 1;
            } else {
                record[0] = 0;
            }
            for(int j = 1; j < cols; j++) {
                if(1 == obstacleGrid[i][j]) {
                    record[j] = 0;
                } else {
                    record[j] += record[j - 1];
                }
            }
        }
        return record[cols - 1];
    }

    public static void main(String[] args) {
        Problem63 problem = new Problem63();
        int[][] nums = new int[3][3];
        nums[0] = new int[] {0, 0, 0};
        nums[1] = new int[] {0, 1, 0};
        nums[2] = new int[] {0, 0, 0};
        System.out.println(2 == problem.uniquePathsWithObstacles(nums));
    }


}
