/*
 * 140. Word Break II
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
package com.chang.leetcode.dp.wordbreak;

import com.chang.common.ArrayToStringUtil;

import java.util.*;

public class Problem140 {

    // Time Limit Exceed
    public List<String> wordBreakTooSlow(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordDict) {
            wordSet.add(str);
        }

        Map<Integer, List<String>> connect = new HashMap<>();
        boolean dp[] = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordSet.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    List<String> befores = connect.getOrDefault(i, new ArrayList<>());
                    if (j == 0) {
                        befores.add(s.substring(j, i + 1));
                    } else {
                        for (String str : connect.get(j - 1)) {
                            befores.add(str + " " + s.substring(j, i + 1));
                        }
                    }
                    connect.put(i, befores);
                }
            }
        }

        return connect.getOrDefault(s.length() - 1, new ArrayList<>());
    }

    public static void main(String[] args) {
        Problem140 problem = new Problem140();
        String[] dict1 = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> res1 = problem.wordBreak("catsanddog", Arrays.asList(dict1));
        System.out.println(ArrayToStringUtil.oneDimension(res1));

        String[] dict2 = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> res2 = problem.wordBreak("pineapplepenapple", Arrays.asList(dict2));
        System.out.println(ArrayToStringUtil.oneDimension(res2));

        String[] dict3 = new String[]{"cats", "dog", "sand", "and", "cat"};
        List<String> res3 = problem.wordBreak("catsandog", Arrays.asList(dict3));
        System.out.println(ArrayToStringUtil.oneDimension(res3));

        String[] dict4 = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        List<String> res4 = problem.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(dict4));
        System.out.println(ArrayToStringUtil.oneDimension(res4));
    }

    public List<String> wordBreak(String s, List<String> words) {
        Set<String> wordDict = new HashSet<>();
        for (String str : words) {
            wordDict.add(str);
        }
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

}
