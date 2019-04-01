/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
package com.chang.leetcode;

public class Problem64 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = 0;
        if(0 == rows || 0 == (cols = grid[0].length)) {
            return 0;
        }

        int[] sum = new int[cols];
        sum[0] = grid[0][0];
        for(int i = 1; i < cols; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        for(int i = 1; i < rows; i++) {
            sum[0] += grid[i][0];
            for(int j = 1; j < cols; j++) {
                sum[j] = Math.min(sum[j - 1], sum[j]) + grid[i][j];
            }
        }
        return sum[cols - 1];
    }

    public static void main(String[] args) {
        Problem64 problem = new Problem64();
        int[][] nums = new int[3][3];
        nums[0] = new int[] {1, 3, 1};
        nums[1] = new int[] {1, 5, 1};
        nums[2] = new int[] {4, 2, 1};
        System.out.println(7 == problem.minPathSum(nums));
    }
}
