/**
 * 375. Guess Number Higher or Lower II
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 * <p>
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
package com.chang.leetcode;

public class Problem375 {

    // wrong
    // find where went wrong
    public int getMoneyAmountWrong(int n) {
        if (1 >= n) {
            return 0;
        }
        int amount = 0;

        int wall = n - 3, flag = n - 1;
        while (n > 0) {
            if (flag <= 0) {
                break;
            }
            if (wall <= 0) {
                amount += flag;
                break;
            }
            amount += flag + wall;
            int count = 0;
            n = wall - 2;
            while (n > 0 && count + n <= flag) {
                count += n;
                n -= 2;
            }
            flag = n;
            wall = n - 2;
        }

        return amount;
    }

    public static void main(String[] args) {
        Problem375 problem = new Problem375();
        System.out.println(2 == problem.getMoneyAmount(3));
        System.out.println(4 == problem.getMoneyAmount(4));
        System.out.println(6 == problem.getMoneyAmount(5));
        System.out.println(14 == problem.getMoneyAmount(9));
        System.out.println(16 == problem.getMoneyAmount(10));
        System.out.println(problem.getMoneyAmount(11));
        System.out.println(problem.getMoneyAmount(12));
        System.out.println(49 == problem.getMoneyAmount(20));

    }

    /**
     * dp[i, j] = x + max{dp[i, x-1], dp[x + 1, j]  i <= x <= j
     */

    // 递归
    public int getMoneyAmountRec(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int res = DP(dp, 1, n);
        return res;
    }

    private int DP(int[][] dp, int s, int e) {
        if (s >= e) return 0;
        if (dp[s][e] != 0) return dp[s][e];
        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            int tmp = i + Math.max(DP(dp, s, i - 1), DP(dp, i + 1, e));
            res = Math.min(res, tmp);
        }
        dp[s][e] = res;
        return res;
    }

    // bottom up
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int e = 2; e <= n; e++) {
            for (int s = e - 1; s > 0; s--) {
                int globalMin = Integer.MAX_VALUE;
                for (int x = s + 1; x < e; x++) {
                    int localMax = x + Math.max(dp[s][x - 1], dp[x + 1][e]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[s][e] = s + 1 == e ? s : globalMin;
            }
        }
        return dp[1][n];
    }

    // 先行后列是行不通的，分析dp过程
//    public int getMoneyAmount(int n) {
//        int[][] dp = new int[n + 1][n + 1];
//        for (int s = 2; s < n; s++) {
//            for (int e = s + 1; e <= n; e++) {
//                int globalMin = Integer.MAX_VALUE;
//                for (int x = s + 1; x < e; x++) {
//                    int localMax = x + Math.max(dp[s][x - 1], dp[x + 1][e]);
//                    globalMin = Math.min(globalMin, localMax);
//                }
//                dp[s][e] = s + 1 == e ? s : globalMin;
//            }
//        }
//        return dp[1][n];
//    }

}
