/*
 * 1253. Reconstruct a 2-Row Binary Matrix
 *
 * Given the following details of a matrix with n columns and 2 rows :
 *
 * The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 * The sum of elements of the 0-th(upper) row is given as upper.
 * The sum of elements of the 1-st(lower) row is given as lower.
 * The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 *
 * Return it as a 2-D integer array.
 *
 * If there are more than one valid solution, any of them will be accepted.
 *
 * If no valid solution exists, return an empty 2-D array.
 *
 * Example 1:
 * Input: upper = 2, lower = 1, colsum = [1,1,1]
 * Output: [[1,1,0],[0,0,1]]
 * Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
 *
 * Example 2:
 * Input: upper = 2, lower = 3, colsum = [2,2,1,1]
 * Output: []
 *
 * Example 3:
 * Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 *
 * Constraints:
 *
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 */
package com.chang.leetcode.contest.weekly162;

import java.util.ArrayList;
import java.util.List;

public class Problem1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        int len = colsum.length;
        int colsumSum = 0;
        for (int i = 0; i < len; i++) {
            colsumSum += colsum[i];
        }

        if (colsumSum != upper + lower) {
            return result;
        }

        List<Integer> upList = new ArrayList<>();
        List<Integer> downList = new ArrayList<>();
        int upperCount = 0;
        for (int n : colsum) {
            int up = 0, down = 0;
            if (n == 2) {
                up = 1;
                down = 1;
                upperCount++;
                if (upperCount > Math.min(upper, lower)) {
                    return result;
                }
            }
            upList.add(up);
            downList.add(down);
        }

        upper -= upperCount;
        upperCount = 0;
        for (int i = 0; i < len; i++) {
            int up = 0, down = 0;
            if (colsum[i] == 1) {
                if (upperCount < upper) {
                    up = 1;
                    upperCount++;
                } else {
                    down = 1;
                }

                upList.set(i, up);
                downList.set(i, down);
            }
        }

        result.add(upList);
        result.add(downList);
        return result;
    }

    public static void main(String[] args) {
        Problem1253 problem = new Problem1253();
        // [[1,1,0],[0,0,1]]
        List<List<Integer>> res1 = problem.reconstructMatrix(2, 1, new int[]{1, 1, 1});

        // []
        List<List<Integer>> res2 = problem.reconstructMatrix(2, 3, new int[]{2, 2, 1, 1});

        // [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
        List<List<Integer>> res3 = problem.reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});

        // []
        List<List<Integer>> res4 = problem.reconstructMatrix(9, 2, new int[]{0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2});

    }

}
