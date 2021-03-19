/*
 * 130. Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border
 * of the board are not flipped to 'X'. Any 'O' that is not on the border and
 * it is not connected to an 'O' on the border will be flipped to 'X'. Two cells
 * are connected if they are adjacent cells connected horizontally or vertically.
 */
package com.chang.leetcode;

public class Problem130 {

    public void solve(char[][] board) {
        int rows = 0;
        int cols = 0;
        if (null == board ||
                0 == (rows = board.length) || 1 == (rows) ||
                0 == (cols = board[0].length) || 1 == (cols)) {
            return;
        }
        boolean[][] record = new boolean[rows][cols];

        for (int i = 0; i < rows; i += rows - 1) {
            for (int j = 0; j < cols; j++) {
                if (('X' == board[i][j]) || record[i][j]) {
                    continue;
                }
                setAdjacent(board, record, i, j);
            }
        }

        for (int j = 0; j < cols; j += cols - 1) {
            for (int i = 1; i < rows - 1; i++) {
                if (('X' == board[i][j]) || record[i][j]) {
                    continue;
                }
                setAdjacent(board, record, i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (('O' == board[i][j]) && !record[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void setAdjacent(char[][] board, boolean[][] record, int row, int col) {
        record[row][col] = true;
        if (row - 1 >= 0 && 'O' == board[row - 1][col] && !record[row - 1][col]) {
            setAdjacent(board, record, row - 1, col);
        }
        if (row + 1 < board.length && 'O' == board[row + 1][col] && !record[row + 1][col]) {
            setAdjacent(board, record, row + 1, col);
        }
        if (col - 1 >= 0 && 'O' == board[row][col - 1] && !record[row][col - 1]) {
            setAdjacent(board, record, row, col - 1);
        }
        if (col + 1 < board[0].length && 'O' == board[row][col + 1] && !record[row][col + 1]) {
            setAdjacent(board, record, row, col + 1);
        }
    }

    public static void main(String[] args) {
        Problem130 problem = new Problem130();
        char[][] board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'O'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};
        problem.solve(board);
        System.out.println("[");
        for (int i = 0; i < 4; i++) {
            System.out.print("[");
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
                System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
