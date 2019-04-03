/**
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
package com.chang.leetcode;

public class Problem91 {

    public int numDecodings(String s) {
        if (0 == s.length()) {
            return 0;
        }
        if (1 == s.length()) {
            if (s.charAt(0) == '0') {
                return 0;
            } else {
                return 1;
            }
        }

        char last = s.charAt(0);
        int pre = 0;
        int res = last == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            last = s.charAt(i - 1);
            char add = s.charAt(i);
            if (last == '0' && add == '0') {
               return 0;
            } else if('1' == last || ('2' == last && add <= '6' && add > '0')) {
                res = pre * 2 + res;
            } else {
                pre = 1;
            }
        }
        return 0;
    }

    public int numDecdingsRec(String s, Character newChar) {
        if (null == s) {
            return 1;
        }

        if (newChar <= '6' && s.charAt(s.length() - 1) <= '2') {

        }
    }

    public static void main(String[] args) {
        Problem91 problem = new Problem91();
        System.out.println(2 == problem.numDecodings("12"));
        System.out.println(3 == problem.numDecodings("226"));
    }
}
