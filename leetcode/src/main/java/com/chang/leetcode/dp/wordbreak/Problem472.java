/**
 * 472. Concatenated Words
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 *  "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 */
package com.chang.leetcode.dp.wordbreak;

import com.chang.common.ArrayToStringUtil;

import java.util.*;

public class Problem472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String s : words) {
            wordSet.add(s);
        }

        for (String s : words) {
            if(0 == s.length()) {
                continue;
            }

            wordSet.remove(s);
            boolean[] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (wordSet.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            if (dp[s.length() - 1]) {
                result.add(s);
            }
            wordSet.add(s);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem472 problem = new Problem472();
        String[] words1 = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> res1 = problem.findAllConcatenatedWordsInADict(words1);
        System.out.println(ArrayToStringUtil.oneDimension(res1));

        String[] words2 = new String[]{""};
        List<String> res2 = problem.findAllConcatenatedWordsInADict(words2);
        System.out.println(ArrayToStringUtil.oneDimension(res2));
    }

    // Using HashSet and dfs
    public List<String> findAllConcatenatedWordsInADictExample(String[] words) {
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet(Arrays.asList(words));

        for (String word : words) {
            set.remove(word);
            if (dfs(word, set, "")) list.add(word);
            set.add(word);
        }
        return list;
    }

    private boolean dfs(String word, Set<String> set, String previous) {
        if (!previous.equals("")) set.add(previous);
        if (set.contains(word)) return true;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (set.contains(prefix) &&
                    dfs(word.substring(i, word.length()), set, previous + prefix)) {
                return true;
            }
        }
        return false;
    }

}
