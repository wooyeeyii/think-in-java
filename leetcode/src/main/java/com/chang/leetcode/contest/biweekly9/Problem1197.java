/*
 * 1197. Minimum Knight Moves
 * 
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 * 
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
 * 
 * Example 1:
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * 
 * Example 2:
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 * 
 * Constraints:
 * 
 * |x| + |y| <= 300
 */
package com.chang.leetcode.contest.biweekly9;

public class Problem1197 {

    public int minKnightMoves(int x, int y) {
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2},
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;

        int[][] dp = new int[x + 5][y + 5];
        dp[2][2] = 1;

        int moves = 0;
        while (dp[x + 2][y + 2] != 1) {
            moves++;
            int[][] next = new int[x + 5][y + 5];
            for (int i = 0; i < x + 5; i++) {
                for (int j = 0; j < y + 5; j++) {
                    if (dp[i][j] == 1) {
                        next[i][j] = 1;
                        continue;
                    }

                    for (int[] dir : dirs) {
                        int x0 = i + dir[0];
                        int y0 = j + dir[1];
                        if (x0 < 0 || x0 > x + 4 || y0 < 0 || y0 > y + 4) {
                            continue;
                        } else {
                            if (dp[x0][y0] == 1) {
                                next[i][j] = 1;
                                break;
                            }
                        }
                    }
                }
            }
            dp = next;

        }
        return moves;
    }

    public static void main(String[] args) {
        Problem1197 problem = new Problem1197();
        System.out.println(0 == problem.minKnightMoves(0, 0));
        System.out.println(1 == problem.minKnightMoves(2, 1));
        System.out.println(4 == problem.minKnightMoves(5, 5));
    }
}
