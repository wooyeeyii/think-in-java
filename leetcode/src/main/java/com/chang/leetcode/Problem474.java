/**
 * 474. Ones and Zeroes
 *
 * In the computer world, use restricted resource you have to generate dpimum benefit is what we always want to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 *
 * Now your task is to find the dpimum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 * Note:
 *
 *     The given numbers of 0s and 1s will both not exceed 100
 *     The size of given string array won't exceed 600.
 *
 *
 *
 * Example 1:
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 *
 *
 *
 * Example 2:
 *
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
package com.chang.leetcode;

public class Problem474 {

    // example dp alg

    /**
     * o better understand, DP[][] can be rewrite as DP[][][],
     * e.g. DP[0][i][j] = 0 means when the string array is empty, we can not form any string.
     * Then we put the first element of strs in our pool, and we can write
     * DP[1][i][j]=Math.max(DP[0][i][j], 1+DP[0][i-c[0]][j-c[1]]); (for each i and j).
     * Actually, we find that each time we add one more string k,
     * DP[k][i][j]=Math.max(DP[k-1][i][j], 1+DP[k-1][i-c[0]][j-c[1]]).
     * Since each i and j will not be influenced by higher i,j, and DP[k-1] will not be used in the future,
     * we can iterate backward and update DP[i][j] in place.
     * In the end, we return DP[m][n] which is actually DP[strs.length][m][n].
     */
    // backward dp
    public int finddpForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(String s : strs) {
            int needZeros = 0;
            int needOnes = 0;
            for(int i = 0; i < s.length(); i++) {
                if('1' == s.charAt(i)) {
                    needOnes++;
                } else {
                    needZeros++;
                }
            }

            for(int i = m; i >= 0; i--) {
                for(int j = n; j >= 0; j--) {
                    int leftZeros = i - needZeros;
                    int leftOnes = j - needOnes;
                    if(leftZeros >= 0 && leftOnes >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[leftZeros][leftOnes] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }
    

    public static void main(String[] args) {
        Problem474 problem = new Problem474();
        String[] strs1 = new String[] {"10", "0001", "111001", "1", "0"};
        System.out.println(4 == problem.finddpForm(strs1, 5, 3));
        String[] strs2 = new String[] {"10", "0", "1"};
        System.out.println(2 == problem.finddpForm(strs2, 1, 1));
    }

    // forward dp
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] max = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            int neededZero = 0;
            int neededOne = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    neededZero++;
                } else {
                    neededOne++;
                }
            }

            int[][] newMax = new int[m + 1][n + 1];

            for (int zero = 0; zero <= m; zero++) {
                for (int one = 0; one <= n; one++) {
                    if (zero >= neededZero && one >= neededOne) {
                        int zeroLeft = zero - neededZero;
                        int oneLeft = one - neededOne;
                        newMax[zero][one] = Math.max(1 + max[zeroLeft][oneLeft], max[zero][one]);
                    } else {
                        newMax[zero][one] = max[zero][one];
                    }
                }
            }

            max = newMax;
        }
        return max[m][n];
    }


}
