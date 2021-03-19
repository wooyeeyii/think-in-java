/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * Example 1:
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
package com.chang.leetcode.array;

public class Problem48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int loop = 0; loop < length / 2; loop++) {
            for (int i = loop; i <= length - 2 - loop; i++) {
                int rightTop = matrix[i][length - loop - 1];
                int rightBottom = matrix[length - loop - 1][length - 1 - i];
                int leftBottom = matrix[length - 1 - i][loop];
                matrix[i][length - loop - 1] = matrix[loop][i];
                matrix[length - loop - 1][length - 1 - i] = rightTop;
                matrix[length - 1 - i][loop] = rightBottom;
                matrix[loop][i] = leftBottom;
            }
        }
    }
}
