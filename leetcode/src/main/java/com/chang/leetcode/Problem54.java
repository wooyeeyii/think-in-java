/*
 * 54. Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < Math.min(rows, cols) / 2; i++) {
            for (int j = i; j <= cols - 1 - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j <= rows - 1 - i; j++) {
                result.add(matrix[j][cols - 1 - i]);
            }
            for (int j = cols - 2 - i; j >= i; j--) {
                result.add(matrix[rows - 1 - i][j]);
            }
            for (int j = rows - 2 - i; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }
        // 可能还剩一行或一列
        if (cols >= rows && 0 != rows % 2) {
            int start = rows / 2;
            for (int j = start; j <= cols - 1 - start; j++) {
                result.add(matrix[start][j]);
            }
        } else if (rows > cols && 0 != cols % 2) {
            int start = cols / 2;
            for (int j = start; j <= rows - 1 - start; j++) {
                result.add(matrix[j][start]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem54 problem = new Problem54();
        int[][] nums = new int[3][4];
        nums[0] = new int[]{1, 2, 3, 4};
        nums[1] = new int[]{5, 6, 7, 8};
        nums[2] = new int[]{9, 10, 11, 12};
        System.out.println(ArrayToStringUtil.oneDimension(problem.spiralOrder(nums)));
        int[][] nums2 = new int[3][1];
        nums2[0][0] = 1;
        nums2[1][0] = 2;
        nums2[2][0] = 3;
        System.out.println(ArrayToStringUtil.oneDimension(problem.spiralOrder(nums2)));
    }
}
