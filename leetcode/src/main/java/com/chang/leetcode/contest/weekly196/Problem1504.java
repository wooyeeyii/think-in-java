/**
 * 1504. Count Submatrices With All Ones
 *
 * Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
 *
 * Example 1:
 * Input: mat = [[1,0,1],
 *               [1,1,0],
 *               [1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 *
 * Constraints:
 *
 * 1 <= rows <= 150
 * 1 <= columns <= 150
 * 0 <= mat[i][j] <= 1
 */
package com.chang.leetcode.contest.weekly196;

public class Problem1504 {

    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (1 == mat[i][j]) {
                    count += count(mat, i, j);
                }
            }
        }
        return count;
    }

    private int count(int[][] mat, int x, int y) {
        int rows = mat.length;
        int cols = mat[0].length;
        int i = x + 1;
        for (; i < rows && 1 == mat[i][y]; i++) {
        }
        int xMax = i - 1;
        int j = y + 1;
        for (; j < cols && 1 == mat[x][j]; j++) {
        }
        int yMax = j - 1;

        return count(mat, x, y, xMax, yMax);
    }

    private int count(int[][] mat, int x, int y, int xMax, int yMax) {
        int count = xMax - x + yMax - y + 1;
        int last = yMax;
        for (int i = x + 1; i <= xMax; i++) {
            int j = y + 1;
            for (; j <= last; j++) {
                if (1 == mat[i][j]) {
                    count++;
                } else {
                    break;
                }
            }
            last = j - 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Problem1504 problem = new Problem1504();
        int[][] mat1 = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}};
        System.out.println(problem.numSubmat(mat1));
        int[][] mat2 = new int[][]{
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(problem.numSubmat(mat2));
        int[][] mat3 = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println(problem.numSubmat(mat3));
    }
}
