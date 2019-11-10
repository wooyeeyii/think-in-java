package com.chang.leetcode.contest.weekly162;

import java.util.ArrayList;
import java.util.List;

public class Problem5256 {

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
        Problem5256 problem = new Problem5256();
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
