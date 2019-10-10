package com.chang.leetcode.contest.weekly156;

public class Problem5214 {

    public int longestSubsequence(int[] arr, int difference) {
        if (null == arr || 0 == arr.length) {
            return 0;
        }

        int len = arr.length;
        int maxLen = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            int before = cur - difference;
            int c = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == cur) {
                    c = difference == 0 ? dp[j] + 1 : dp[j];
                    break;
                }
                if (arr[j] == before) {
                    c = dp[j] + 1;
                    break;
                }
            }
            dp[i] = c;
            if (maxLen < c) {
                maxLen = c;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Problem5214 problem = new Problem5214();
        System.out.println(4 == problem.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(1 == problem.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(4 == problem.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        System.out.println(2 == problem.longestSubsequence(new int[]{3, 4, -3, -2, -4}, -5));
        System.out.println(2 == problem.longestSubsequence(new int[]{4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8}, 0));
    }


}
