/**
 * 139 Word Break
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
package com.chang.leetcode.dp.wordbreak;

import java.util.*;

public class Problem139 {

    // Time Limit Exceeded
    public boolean wordBreakTooSlow(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict);
    }

    public boolean wordBreak(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        System.out.println("########### " + start);
        for (String str : wordDict) {
            if (s.length() - start >= str.length() &&
                    str.equals(s.substring(start, start + str.length()))) {
                if (wordBreak(s, start + str.length(), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Problem139 problem = new Problem139();
//        String[] dict1 = new String[] {"leet", "code"};
//        System.out.println(problem.wordBreak("leetcode", new ArrayList<>(Arrays.asList(dict1))));
//        String[] dict2 = new String[] {"apple", "pen"};
//        System.out.println(problem.wordBreak("applepenapple", new ArrayList<>(Arrays.asList(dict2))));
//        String[] dict3 = new String[] {"cats", "dog", "sand", "and", "cat"};
//        System.out.println(!problem.wordBreak("catsandog", new ArrayList<>(Arrays.asList(dict3))));
        String[] dict4 = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
                "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        System.out.println(!problem.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<>(Arrays.asList(dict4))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        wordDict.forEach(str -> dict.add(str));
        if (s == null || s.length() == 0) return false;

        int n = s.length();
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

}
