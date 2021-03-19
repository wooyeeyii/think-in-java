/*
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * 
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 * 
 * Example 1:
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * 
 * Example 2:
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * 
 * Example 3:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * 
 * Example 4:
 * Input: s = "g"
 * Output: 0
 * 
 * Example 5:
 * Input: s = "no"
 * Output: 1
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500
 * All characters of s are lower case English letters.
 */
package com.chang.leetcode.contest.weekly170;

public class Problem1312 {

    // find the longest subString which is palindrome.
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseqDP(s);
    }

    public int longestPalindromeSubseqDP(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Problem1312 problem = new Problem1312();
        System.out.println(0 == problem.minInsertions("g"));
        System.out.println(0 == problem.minInsertions("zzazz"));
        System.out.println(1 == problem.minInsertions("no"));
        System.out.println(2 == problem.minInsertions("mbadm"));
        System.out.println(5 == problem.minInsertions("leetcode"));

    }

}
