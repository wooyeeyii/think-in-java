/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
package com.chang.leetcode;

public class Problem79 {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = 0;
        if(0 == rows || (cols = board[0].length) == 0) {
            return false;
        }
        if(null == word || "".equals(word)) {
            return true;
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean exist = subExist(board, i, j, word.substring(1, word.length()));
                    if(exist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean subExist(char[][] board, int row, int col, String word) {
        if(null == word || "".equals(word)) {
            return true;
        }
        char above = row - 1 >= 0? board[row - 1][col] : 0;
        char below = row + 1 < board.length? board[row + 1][col] : 0;
        char left = col - 1 >=0? board[row][col - 1] : 0;
        char right = col + 1 < board[0].length? board[row][col + 1]: 0;
        if(above != 0 && above == word.charAt(0)) {
            boolean flag = subExist(board, row - 1, col, word.substring(1, word.length()));
            if(flag) {
                return true;
            }
        }
        if(below != 0 && below == word.charAt(0)) {
            boolean flag = subExist(board, row + 1, col, word.substring(1, word.length()));
            if(flag) {
                return true;
            }
        }
        if(left != 0 && left == word.charAt(0)) {
            boolean flag = subExist(board, row, col - 1, word.substring(1, word.length()));
            if(flag) {
                return true;
            }
        }
        if(right != 0 && right == word.charAt(0)) {
            boolean flag = subExist(board, row, col + 1, word.substring(1, word.length()));
            if(flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem79 problem = new Problem79();
        char[][] board = new char[3][4];
        board[0] = new char[] {'A','B','C','E'};
        board[1] = new char[] {'S','F','C','S'};
        board[2] = new char[] {'A','B','C','E'};
        System.out.println(true == problem.exist(board, "ABCCED"));
        System.out.println(true == problem.exist(board, "SEE"));
        System.out.println(false == problem.exist(board, "ABCB"));
    }
}
