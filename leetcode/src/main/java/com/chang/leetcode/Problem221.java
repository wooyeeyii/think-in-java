/**
 * 221. Maximal Square
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        int rows = 0;
        int cols = 0;
        if (null == matrix || 0 == (rows = matrix.length)) {
            return 0;
        }
        if (0 == (cols = matrix[0].length)) {
            return 0;
        }
        int size = 0;
        char[][] matrixExt = new char[rows + 1][cols + 1];
        List<List<Integer>> flag = new ArrayList<>();
        for (int i = 0; i <= cols; i++) {
            matrixExt[rows][i] = '0';
        }
        for (int i = 0; i <= rows; i++) {
            matrixExt[i][cols] = '0';
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixExt[i][j] = matrix[i][j];
                if ('1' == matrix[i][j]) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    flag.add(pos);
                }
            }
        }
        while (flag.size() > 0) {
            size++;
            List<List<Integer>> next = new ArrayList<List<Integer>>();
            flag.forEach(list -> {
                int m = list.get(0);
                int n = list.get(1);
                if ('0' == matrixExt[m + 1][n] || '0' == matrixExt[m][n + 1] || '0' == matrixExt[m + 1][n + 1]) {
                    matrixExt[m][n] = '0';
                } else {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(m);
                    pos.add(n);
                    next.add(pos);
                }
            });
            flag = next;
        }
        return size * size;
    }

    public static void main(String[] args) {
        Problem221 problem = new Problem221();
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        System.out.println(4 == problem.maximalSquare(matrix));

        char[][] matrix2 = new char[2][];
        matrix2[0] = new char[]{'0', '1'};
        matrix2[1] = new char[]{'0', '1'};
        System.out.println(1 == problem.maximalSquare(matrix2));
    }


    public int maximalSquareTry(char[][] matrix) {
        int rows = 0;
        int cols = 0;
        if (null == matrix || 0 == (rows = matrix.length)) {
            return 0;
        }
        if (0 == (cols = matrix[0].length)) {
            return 0;
        }
        int size = 0;
        List<List<Integer>> flag = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ('1' == matrix[i][j]) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    flag.add(pos);
                    if (rows - 1 == i || cols - 1 == j) {
                        matrix[i][j] = '0';
                    }
                }
            }
        }
        while (flag.size() > 0) {
            size++;
            List<List<Integer>> next = new ArrayList<List<Integer>>();
            flag.forEach(list -> {
                int m = list.get(0);
                int n = list.get(1);
                if (m < matrix.length - 1 && n < matrix[0].length - 1) {
                    if ('0' == matrix[m + 1][n] || '0' == matrix[m][n + 1] || '0' == matrix[m + 1][n + 1]) {
                        matrix[m][n] = '0';
                    } else {
                        List<Integer> pos = new ArrayList<>();
                        pos.add(m);
                        pos.add(n);
                        next.add(pos);
                    }
                }
            });
            flag = next;
        }
        return size * size;
    }
}
