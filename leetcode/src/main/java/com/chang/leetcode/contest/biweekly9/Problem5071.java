package com.chang.leetcode.contest.biweekly9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5071 {

    public int smallestCommonElement(int[][] mat) {
        int rows = 0;
        int cols = 0;
        if(null == mat || 0 == (rows = mat.length) || 0 == (cols = mat[0].length)) {
            return -1;
        }

        int[] same = mat[0];
        for(int i = 1; i < rows; i++) {
            same = findSame(same, mat[i]);
            if(null == same || 0 == same.length) {
                return -1;
            }
        }

        return same[0];
    }

    private int[] findSame(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Problem5071 problem = new Problem5071();

        int[][] mat1 = new int[][]{{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        System.out.println(5 == problem.smallestCommonElement(mat1));

        int[][] mat2 = new int[][]{{1, 2, 3, 4, 5}, {9, 10, 11, 12, 13}};
        System.out.println(-1 == problem.smallestCommonElement(mat2));
    }
}
