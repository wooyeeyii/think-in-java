/**
 * 62. Unique Paths
 * <p>
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[] record = new int[n];
        Arrays.fill(record, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                record[j] += record[j - 1];
            }
        }
        return record[n - 1];
    }

    public static void main(String[] args) {
        Problem62 problem = new Problem62();
        System.out.println(1 == problem.uniquePaths(1, 1));
        System.out.println(3 == problem.uniquePaths(3, 2));
        System.out.println(28 == problem.uniquePaths(7, 3));
    }
}
