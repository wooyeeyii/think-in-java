package com.chang.leetcode.contest.weekly156;

public class Problem5215 {

    int max = 0;
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) {
                    boolean[][] visited = new boolean[rows][cols];
                    mine(grid, visited, i, j, 0);
                }
            }
        }
        return max;
    }

    private void mine(int[][] board, boolean[][] visited, int x, int y, int total) {
        int rows = board.length, cols = board[0].length;
        if(x < 0 || x >= rows || y < 0 || y >= cols || 0 == board[x][y] || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        total += board[x][y];
        max = Math.max(max, total);
        for(int[] dir : dirs) {
            mine(board, visited, x + dir[0], y + dir[1], total);
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        Problem5215 problem = new Problem5215();
//        int[][] grid1 = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
//        System.out.println(24 == problem.getMaximumGold(grid1));
        int[][] grid2 = new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(28 == problem.getMaximumGold(grid2));
    }


}
