/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem73 {
    public void setZeroes(int[][] matrix) {
        int length1 = matrix.length;
        int length2 = 0;
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        if(length1 <= 0) {
            return;
        }
        
        length2 = matrix[0].length;
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int m = 0; m < rows.size(); m++) {
            for(int n = 0; n < length2; n++) {
                matrix[rows.get(m)][n] = 0;
            }
        }
        for(int m = 0; m < cols.size(); m++) {
            for(int n = 0; n < length1; n++) {
                matrix[n][cols.get(m)] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        Problem73 problem = new Problem73();
        
    }
}
