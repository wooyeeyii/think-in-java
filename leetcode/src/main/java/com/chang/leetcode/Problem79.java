/**
 * 79. Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
package com.chang.leetcode;

public class Problem79 {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = 0;
        if (0 == rows || (cols = board[0].length) == 0) {
            return false;
        }
        if (null == word || "".equals(word)) {
            return true;
        }
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && subExist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean subExist(char[][] board, int row, int col, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        if (row >= board.length || row < 0 ||
                col >= board[row].length || col < 0 ||
                board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (subExist(board, row - 1, col, word, index + 1) ||
                subExist(board, row + 1, col, word, index + 1) ||
                subExist(board, row, col - 1, word, index + 1) ||
                subExist(board, row, col + 1, word, index + 1)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Problem79 problem = new Problem79();
        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};
        System.out.println(true == problem.exist(board, "ABCCED"));
        System.out.println(true == problem.exist(board, "SEE"));
        System.out.println(false == problem.exist(board, "ABCB"));
    }
}
