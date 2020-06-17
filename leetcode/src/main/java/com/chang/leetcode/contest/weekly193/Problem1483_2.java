package com.chang.leetcode.contest.weekly193;

public class Problem1483_2 {

    int[][] jump;
    int maxPow;

    public Problem1483_2(int n, int[] parent) {
        // log_base_2(n)
        maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
        jump = new int[maxPow][n];
        jump[0] = parent;
        for (int p = 1; p < maxPow; p++) {
            for (int j = 0; j < n; j++) {
                int pre = jump[p - 1][j];
                jump[p][j] = pre == -1 ? -1 : jump[p - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int maxPow = this.maxPow;
        while (k > 0 && node > -1) {
            if (k >= 1 << maxPow) {
                node = jump[maxPow][node];
                k -= 1 << maxPow;
            } else
                maxPow -= 1;
        }
        return node;
    }

    public static void main(String[] args) {
        Problem1483_2 problem = new Problem1483_2(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(1 == problem.getKthAncestor(3, 1));
        System.out.println(0 == problem.getKthAncestor(5, 2));
        System.out.println(-1 == problem.getKthAncestor(6, 3));

    }
}
