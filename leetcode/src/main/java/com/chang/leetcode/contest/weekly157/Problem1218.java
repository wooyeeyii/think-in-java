/**
 * 1218. Longest Arithmetic Subsequence of Given Difference
 *
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr
 * which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference
 *
 * Example 1:
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 *
 * Example 2:
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 *
 * Example 3:
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 *
 */
package com.chang.leetcode.contest.weekly157;

import java.util.HashMap;
import java.util.Map;

public class Problem1218 {

    public int longestSubsequenceSlow(int[] arr, int difference) {
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

    // use map to keep record
    public int longestSubsequence(int[] arr, int difference) {
        if (null == arr || 0 == arr.length) {
            return 0;
        }

        int len = arr.length;
        int maxLen = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            int before = cur - difference;
            int c = map.getOrDefault(before, 0) + 1;
            map.put(cur, c);
            maxLen = Math.max(maxLen, c);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Problem1218 problem = new Problem1218();
        System.out.println(4 == problem.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(1 == problem.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(4 == problem.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        System.out.println(2 == problem.longestSubsequence(new int[]{3, 4, -3, -2, -4}, -5));
        System.out.println(2 == problem.longestSubsequence(new int[]{4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8}, 0));
    }


}
