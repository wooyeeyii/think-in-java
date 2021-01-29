package com.chang.leetcode.contest.weekly219;

public class Problem5627 {

    public static void main(String[] args) {
        Problem5627 problem = new Problem5627();
        // 6
        System.out.println(problem.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        // 122
        System.out.println(problem.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length, prefix[] = new int[n], dp[] = new int[n];

        for (var i = 0; i < n; i++) {
            prefix[i] = stones[i] + (i > 0 ? prefix[i - 1] : 0);
        }

        for (var i = 0; i < n - 1; i++) {
            dp[i] = Math.max(stones[i], stones[i + 1]);
        }

        for (var l = 2; l < n; l++) {
            // length of current stone array = l + 1
            for (var i = 0; i < n - l; i++) {
                dp[i] = Math.max(
                        prefix[i + l - 1] - (i > 0 ? prefix[i - 1] : 0) - dp[i],      // sum(i, i + l - 1)
                        prefix[i + l] - prefix[i] - dp[i + 1]
                );
            }
        }

        return dp[0];
    }

    public int stoneGameVIIExample2(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        for (int l = 2; l <= n; l++) {
            for (int start = 0; start + l - 1 < n; start++) {
                int end = start + l - 1;
                dp[start][end] = Math.max(sum[end + 1] - sum[start + 1] - dp[start + 1][end],
                        sum[end] - sum[start] - dp[start][end - 1]);

            }
        }
        return dp[0][n - 1];
    }

}
