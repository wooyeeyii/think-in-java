/*
 * 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 */
package com.chang.leetcode.string;

public class Problem44 {

    public boolean isMatch(String s, String p) {
        // if s is empty, then p must be empty or only contains '*'
        if (null == s || 0 == s.length()) {
            if (null == p || 0 == p.length()) {
                return true;
            }
            int i = 0;
            for (; i < p.length(); i++) {
                if ('*' != p.charAt(i)) {
                    break;
                }
            }
            return i == p.length();
        }

        int sIdx = 0, pIdx = 0, matchIdx = 0, lastStarIdx = -1;
        while (sIdx < s.length()) {
            if (pIdx < p.length() && ('?' == p.charAt(pIdx) || s.charAt(sIdx) == p.charAt(pIdx))) {
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && '*' == p.charAt(pIdx)) {
                lastStarIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            } else if (-1 != lastStarIdx) {
                sIdx = ++matchIdx;
                pIdx = lastStarIdx + 1;
            } else {
                return false;
            }
        }

        //check for remaining characters in pattern
        while (pIdx < p.length() && '*' == p.charAt(pIdx)) {
            pIdx++;
        }

        return pIdx == p.length();
    }

    public static void main(String[] args) {
        Problem44 problem = new Problem44();
        System.out.println(problem.isMatch("", ""));
        System.out.println(problem.isMatch("", "?"));
        System.out.println(problem.isMatch("", "*"));
        System.out.println(problem.isMatch("", "***"));
        System.out.println(problem.isMatch("abc", "a?c"));
        System.out.println(problem.isMatch("abcd", "a*d*"));
        System.out.println(problem.isMatch("aa", "a"));
    }

}

