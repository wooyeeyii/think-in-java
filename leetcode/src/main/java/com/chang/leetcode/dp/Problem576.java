/*
 * 576. Out of Boundary Paths
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or
 * cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times.
 * Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
 *
 * Example 1:
 * Input: m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 *
 * Example 2
 * Input: m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 *
 * Note:
 *
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 */
package com.chang.leetcode.dp;

public class Problem576 {

    // learn
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][][] count = new int[N + 1][m][n];

        count[0][i][j] = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int result = 0;
        for (int k = 1; k <= N; k++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[k - 1][r][c]) % MOD;
                        } else {
                            count[k][nr][nc] = (count[k][nr][nc] + count[k - 1][r][c]) % MOD;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem576 problem = new Problem576();
        System.out.println(6 == problem.findPaths(2, 2, 2, 0, 0));
        System.out.println(12 == problem.findPaths(1, 3, 3, 0, 1));
    }

    // example
    // DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i,
    // DP[i][j][k] only depends on DP[i - 1][j][k], so we can compress 3 dimensional dp array to 2 dimensional.
    public int findPathsImpro(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }

        return result;
    }

}
