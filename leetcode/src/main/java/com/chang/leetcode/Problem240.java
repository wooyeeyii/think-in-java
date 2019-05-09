/**
 * 240. Search a 2D Matrix II
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example:
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
package com.chang.leetcode;

public class Problem240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix) {
            return false;
        }
        int rows = matrix.length;
        int cols = 0;
        if (rows <= 0 || (cols = matrix[0].length) <= 0) {
            return false;
        }
        if (target > matrix[rows - 1][cols - 1] || target < matrix[0][0]) {
            return false;
        }
        return searchMatrixDiv(matrix, target, 0, rows - 1, 0, cols - 1);
    }

    private boolean searchMatrixDiv(int[][] matrix, int target,
                                    int startRow, int endRow, int startCol, int endCol) {
//        if(startRow < 0 || endRow >= matrix[0].length || startRow > endRow ||
//                startCol < 0 || endCol >= matrix[0].length || startCol > endCol) {
        if (startRow > endRow || startCol > endCol) {
            return false;
        }

        int middleRow = startRow + (endRow - startRow) / 2;
        if (matrix[middleRow][endCol] < target) {
            return searchMatrixDiv(matrix, target, middleRow + 1, endRow, startCol, endCol);
        } else if (matrix[middleRow][startCol] > target) {
            return searchMatrixDiv(matrix, target, startRow, middleRow - 1, startCol, endCol);
        } else {
            int j = startCol;
            for (; j <= endCol; j++) {
                if (matrix[middleRow][j] == target) {
                    return true;
                } else if (matrix[middleRow][j] < target) {
                    continue;
                } else {
                    break;
                }
            }
            return searchMatrixDiv(matrix, target, startRow, middleRow - 1, j, endCol) ||
                    searchMatrixDiv(matrix, target, middleRow + 1, endRow, startCol, j - 1);
        }
    }

    public static void main(String[] args) {
        Problem240 problem = new Problem240();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(true == problem.searchMatrix(matrix, 5));
        System.out.println(false == problem.searchMatrix(matrix, 20));

    }

    public boolean searchMatrixExample(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

}
