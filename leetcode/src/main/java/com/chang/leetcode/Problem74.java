/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of
 * the previous row.
 * <p>
 * Example 1:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * <p>
 * Example 2:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 */
package com.chang.leetcode;

public class Problem74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = 0;
        if (0 == rows || 0 == (cols = matrix[0].length)) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
//        int rowPos = findRowNormal(matrix, target);
        int rowPos = findRowDivid(matrix, target);
        return dividFind(matrix[rowPos], target);
    }

    private int findRowNormal(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if ((target >= matrix[i][0] && target < matrix[i + 1][0])) {
                return i;
            }
        }
        return matrix.length - 1;
    }

    private int findRowDivid(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int start = 0;
        int end = matrix.length - 1;
        int middle = -1;
        while (start <= end) {
            middle = (start + end) / 2;
            if ((target >= matrix[middle][0] && target <= matrix[middle][cols - 1])) {
                return middle;
            } else if (target < matrix[middle][0]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return middle;
    }

    private boolean dividFind(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem74 problem = new Problem74();
        int[][] nums1 = new int[2][1];
        nums1[0] = new int[]{1};
        nums1[1] = new int[]{3};
        System.out.println(problem.searchMatrix(nums1, 1));
    }


}
