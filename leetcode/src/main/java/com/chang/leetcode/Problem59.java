/**
 * 59. Spiral Matrix II
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
package com.chang.leetcode;

public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j <= n - 1 - i; j++) {
                result[i][j] = num++;
            }
            for (int j = i + 1; j <= n - 1 - i; j++) {
                result[j][n - 1 - i] = num++;
            }
            for (int j = n - 2 - i; j >= i; j--) {
                result[n - 1 - i][j] = num++;
            }
            for (int j = n - 2 - i; j > i; j--) {
                result[j][i] = num++;
            }
        }
        if (0 != n % 2) {
            int start = n / 2;
            for (int j = start; j <= n - 1 - start; j++) {
                result[start][j] = num++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem59 problem = new Problem59();
        problem.generateMatrix(3);
    }
}
