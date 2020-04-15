/**
 * 392. Is Subsequence
 * <p>
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is
 * potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 * and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem392 {

    public boolean isSubsequenceSlow(String s, String t) {
        int[] d = new int[s.length()];
        int start = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            for (int j = start; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    start = j + 1;
                    count++;
                    break;
                }
            }
        }
        return count == s.length();
    }

    public static void main(String[] args) {
        Problem392 problem = new Problem392();
        System.out.println(problem.isSubsequence("abc", "ahbgdc"));
        System.out.println(!problem.isSubsequence("axc", "ahbgdc"));
        System.out.println(!problem.isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (null == idx[s.charAt(i)]) return false;
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }

}
