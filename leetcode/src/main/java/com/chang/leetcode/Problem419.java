/**
 * 419. Battleships in a Board
 *
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's,
 * empty slots are represented with '.'s. You may assume the following rules:
 *
 *     You receive a valid board, made of only battleships or empty slots.
 *     Battleships can only be placed horizontally or vertically. In other words,
 *     they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column),
 *     where N can be of any size.
 *     At least one horizontal or vertical cell separates between two battleships -
 *     there are no adjacent battleships.
 *
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 *
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 *
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */
package com.chang.leetcode;

public class Problem419 {

    public int countBattleships(char[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length) {
            return 0;
        }

        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][i] && 'X' == board[i][j]) {
                    travel(board, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void travel(char[][] board, boolean[][] visited, int x, int y) {
        int rows = board.length, cols = board[0].length;
        if(x < 0 || x >= rows || y < 0 || y >= cols || '.' == board[x][y] || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        board[x][y] = '.';
        for(int[] dir : dirs) {
            travel(board, visited, x + dir[0], y + dir[1]);
        }

    }

    /**
     * improve
     */
    public int countBattleshipsImpro(char[][] board) {
        if (null == board || 0 == board.length || 0 == board[0].length) {
            return 0;
        }

        int rows = board.length, cols = board[0].length;
        int[] dp = new int[cols];
        dp[0] = board[0][0] == 'X' ? 1 : 0;
        for (int j = 1; j < cols; j++) {
            if(board[0][j] == 'X' && board[0][j - 1] != 'X') {
                dp[j] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            dp[0] = (board[i][0] == 'X' && board[i - 1][0] != 'X') ? dp[0] + 1 : dp[0];
            for (int j = 1; j < cols; j++) {
                if(board[i][j] == 'X' && board[i][j - 1] != 'X' && board[i - 1][j] != 'X') {
                    dp[j] += 1;
                }
            }
        }

        int count = 0;
        for(int a : dp) {
            count += a;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem419 problem = new Problem419();
        char[][] board1 = new char[][] {{'X','.'},{'.', 'X'}};
        System.out.println(2 == problem.countBattleshipsImpro(board1));
    }


}