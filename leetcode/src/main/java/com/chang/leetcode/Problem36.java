package com.chang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem36 {

    public boolean isValidSudoku(char[][] board) {
        int length = 9;
        int i = 0, j = 0;
        for (i = 0; i < length; i++) {
            //第i行
            if (!isNineNumberValid(board[i])) {
                return false;
            }
            //第i列
            char[] tmp = new char[length];
            for (j = 0; j < length; j++) {
                tmp[j] = board[j][i];
            }
            if (!isNineNumberValid(tmp)) {
                return false;
            }
        }

        i = 0;
        while (i < length) {
            j = 0;
            while (j < length) {
                char[] tmp = new char[length];
                int count = 0;
                for (int m = i; m < 3 + i; m++) {
                    for (int n = j; n < 3 + j; n++) {
                        tmp[count++] = board[m][n];
                    }
                }
                if (!isNineNumberValid(tmp)) {
                    return false;
                }
                j += 3;
            }
            i += 3;
        }
        return true;
    }

    private boolean isNineNumberValid(char[] nineNumber) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            if (nineNumber[i] == '.') {
                continue;
            }

            if (set.contains(String.valueOf(nineNumber[i]))) {
                return false;
            }
            set.add(String.valueOf(nineNumber[i]));
        }
        return true;
    }

    public static void main(String[] args) {
        //char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
//		char[][] board = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
//		Problem36 problem = new Problem36();
//		System.out.println(problem.isValidSudoku(board));

        int i = 4;
        System.out.println((i / 3));
    }

}
