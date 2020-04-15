/**
 * 498. Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note:
 * <p>
 * The total number of elements of the given matrix will not exceed 10,000.
 */
package com.chang.leetcode;

public class Problem498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (null == matrix) {
            return null;
        }
        int rows = matrix.length;
        int cols = 0;
        if (0 == rows || 0 == (cols = matrix[0].length)) {
            return new int[0];
        }
        int[] result = new int[rows * cols];

        int pos = 0;
        for (int i = 0; i <= (rows + cols - 2); i++) {
            if (0 == i % 2) {
                for (int row = Math.min(i, rows - 1); row >= 0 && (i - row) >= 0 && (i - row) < cols; row--) {
                    result[pos++] = matrix[row][i - row];
                }
            } else {
                for (int col = Math.min(i, cols - 1); col >= 0 && (i - col) >= 0 && (i - col) < rows; col--) {
                    result[pos++] = matrix[i - col][col];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem498 problem = new Problem498();
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] res = problem.findDiagonalOrder(matrix1);
    }
}
