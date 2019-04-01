package com.chang.leetcode.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem48Test {

    private Problem48 problem = new Problem48();

    @Test
    public void rotate() {
        int[][] matrix0 = {};
        problem.rotate(matrix0);

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        problem.rotate(matrix);

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        problem.rotate(matrix2);

        int[][] matrix3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        problem.rotate(matrix3);
    }
}