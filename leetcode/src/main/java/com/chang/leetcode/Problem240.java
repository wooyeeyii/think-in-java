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
        int cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        int top = 0, bottom = rows - 1;
        while (top < bottom) {
            int middle = top + (bottom - top) / 2;
            if (matrix[middle][0] > target) {
                bottom = middle - 1;
            } else {
                top = middle;
            }
        }

        int left = 0, right = cols - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target == matrix[top][middle]) {
                return true;
            } else if (target > matrix[top][middle]) {
                left = middle - 1;
            } else {
                right = middle + 1;
            }

        }

        return false;
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

}
