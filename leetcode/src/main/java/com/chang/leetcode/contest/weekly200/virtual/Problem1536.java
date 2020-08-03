package com.chang.leetcode.contest.weekly200.virtual;

public class Problem1536 {

    public int minSwaps(int[][] grid) {
        int moves = 0;
        int n = grid.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int zeros = 0, j = n - 1;
            while (j >= 0 && 0 == grid[i][j]) {
                zeros++;
                j--;
            }
            cnt[i] = zeros;
        }

        for (int i = 0; i < n; i++) {
            if (cnt[i] >= n - i - 1) {
                continue;
            } else {
                int mv = move(cnt, i);
                if (-1 == mv) {
                    return -1;
                }
                moves += mv;
            }
        }

        return moves;
    }

    private int move(int[] cnt, int k) {
        int len = cnt.length;
        int target = -1;
        for (int i = k + 1; i < len; i++) {
            if (cnt[i] >= len - k - 1) {
                target = i;
                break;
            }
        }

        if (-1 == target) {
            return -1;
        }

        int tmp = cnt[target];
        for (int i = target; i > k; i--) {
            cnt[i] = cnt[i - 1];
        }
        cnt[k] = tmp;

        return target - k;
    }

    public static void main(String[] args) {
        Problem1536 problem = new Problem1536();
        System.out.println(problem.minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
    }

}
