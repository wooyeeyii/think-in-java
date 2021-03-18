/*
 * 85. Maximal Rectangle
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 * Input: matrix = []
 * Output: 0
 *
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 * Constraints:
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
package com.chang.leetcode.dp;

import java.util.Arrays;

public class Problem85 {

    // copy write
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || 0 == matrix.length || null == matrix[0] || 0 == matrix[0].length) {
            return 0;
        }

        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n - 1);

        for (char[] chars : matrix) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if ('1' == chars[j]) {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }

            int lB = 0;
            for (int i = 0; i < n; i++) {
                if ('1' == chars[i]) {
                    height[i] += 1;
                    left[i] = Math.max(left[i], lB);

                    max = Math.max(max, height[i] * (right[i] - left[i] + 1));
                } else {
                    height[i] = 0;
                    left[i] = 0;
                    lB = i + 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem85 problem = new Problem85();
        // 6
        System.out.println(problem.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        // 0
        System.out.println(problem.maximalRectangle(new char[][]{}));
        // 0
        System.out.println(problem.maximalRectangle(new char[][]{{'0'}}));
        // 1
        System.out.println(problem.maximalRectangle(new char[][]{{'1'}}));
        // 0
        System.out.println(problem.maximalRectangle(new char[][]{{'0', '0'}}));
    }

    /* we start from the first row, and move downward;
     * height[i] record the current number of countinous '1' in column i;
     * left[i] record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[i];
     * right[i] record the right most index j which satifies that for any index k from i to  j, height[k] >= height[i];
     * by understanding the definition, we can easily figure out we need to update maxArea with value (height[i] * (right[i] - left[i] + 1));
     *
     * Then the question is how to update the array of height, left, and right
     * =================================
     * for updating height, it is easy
     * for (int j = 0; j < n; j++) {
     *    if (matrix[i][j] == '1') height[j]++;
     *    else height[j] = 0;
     * }
     * =============================================================================
     * It is a little bit tricky for initializing and updating left and right array
     * for initialization:
     * we know initially, height array contains all 0, so according to the definition of left and right array, left array should contains all 0, and right array should contain all n - 1
     * for updating left and right, it is kind of tricky to understand...
     *     ==============================================================
     *     Here is the code for updating left array, we scan from left to right
     *     int lB = 0;  //lB is indicating the left boundry for the current row of the matrix (for cells with char "1"), not the height array...
     *     for (int j = 0; j < n; j++) {
     *          if (matrix[i][j] == '1') {
     *              left[j] = Math.max(left[j], lB); // this means the current boundry should satisfy two conditions: within the boundry of the previous height array, and within the boundry of the current row...
     *          } else {
     *              left[j] = 0; // when matrix[i][j] = 0, height[j] will get update to 0, so left[j] becomes 0, since all height in between 0 - j satisfies the condition of height[k] >= height[j];
     *              lB = j + 1; //and since current position is '0', so the left most boundry for next "1" cell is at least j + 1;
     *          }
     *     }
     *     ==============================================================
     *     the idea for updating the right boundary is similar, we just need to iterate from right to left
     *     int rB = n - 1;
     *     for (int j = n - 1; j >= 0; j--) {
     *         if (matrix[i][j] == '1') {
     *              right[j] = Math.min(right[j], rB);
     *         } else {
     *              right[j] = n - 1;
     *              rB = j - 1;
     *      }
     */
    public int maximalRectangleDp(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n - 1);
        for (char[] chars : matrix) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }
            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }


}
