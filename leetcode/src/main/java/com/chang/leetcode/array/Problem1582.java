/*
 * 1582. Special Positions in a Binary Matrix
 *
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.
 *
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 * Example 1:
 * Input: mat = [[1,0,0],
 *               [0,0,1],
 *               [1,0,0]]
 * Output: 1
 * Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 *
 * Example 2:
 * Input: mat = [[1,0,0],
 *               [0,1,0],
 *               [0,0,1]]
 * Output: 3
 * Explanation: (0,0), (1,1) and (2,2) are special positions.
 *
 * Example 3:
 * Input: mat = [[0,0,0,1],
 *               [1,0,0,0],
 *               [0,1,1,0],
 *               [0,0,0,0]]
 * Output: 2
 *
 * Example 4:
 * Input: mat = [[0,0,0,0,0],
 *               [1,0,0,0,0],
 *               [0,1,0,0,0],
 *               [0,0,1,0,0],
 *               [0,0,0,1,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is 0 or 1.
 *
 */
package com.chang.leetcode.array;

public class Problem1582 {

    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean[] rowCount = new boolean[rows];
        boolean[] colCount = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            int cnt = 0;
            for (int j = 0; j < cols && cnt <= 1; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
            rowCount[i] = cnt == 1;
        }

        for (int i = 0; i < cols; i++) {
            int cnt = 0;
            for (int j = 0; j < rows && cnt <= 1; j++) {
                if (mat[j][i] == 1) {
                    cnt++;
                }
            }
            colCount[i] = cnt == 1;
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rowCount[i] && colCount[j]) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1582 problem = new Problem1582();
        System.out.println(problem.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public int numSpecialImprove(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for (int i = 0; i < rows; i++) {
            int cnt = 0;
            for (int j = 0; j < cols && cnt <= 1; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && 1 == rowCount[i] && 1 == colCount[j]) {
                    result++;
                }
            }
        }

        return result;
    }

}
