/*
 * 1170. Compare Strings by Frequency of the Smallest Character
 *
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 *
 * Example 1:
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 *
 * Example 2:
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 *
 * Constraints:
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
package com.chang.leetcode.contest.weekly151;

import java.util.Arrays;

public class Problem1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryCount = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryCount[i] = minCount(queries[i]);
        }
        int[] wordCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordCount[i] = minCount(words[i]);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (wordCount[j] > queryCount[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    private int minCount(String s) {
        int[] flag = new int[26];
        Arrays.fill(flag, 0);
        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] > 0) {
                return flag[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem1170 problem = new Problem1170();
        // 1
        int[] res1 = problem.numSmallerByFrequencyExample(new String[]{"cbd"}, new String[]{"zaaaz"});
        // 1, 2
        int[] res2 = problem.numSmallerByFrequencyExample(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"});
    }

    public int[] numSmallerByFrequencyExample(String[] queries, String[] words) {

        int qn = queries.length, wn = words.length;
        int[] res = new int[qn];
        int[] fre = new int[11];    // word.length <= 10
        for (String w : words) {
            int cur = helper(w);
            fre[cur]++;
        }
        int[] sum = new int[11];
        sum[10] = fre[10];
        for (int i = 9; i > 0; i--) {
            sum[i] = fre[i] + sum[i + 1];
        }
        for (int i = 0; i < qn; i++) {
            int cur = helper(queries[i]);
            res[i] = cur == 10 ? 0 : sum[cur + 1];
        }
        return res;
    }

    private int helper(String s) {
        int len = s.length(), count = 1;
        char min = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char cur = s.charAt(i);
            if (cur == min) count++;
            else if (cur < min) {
                min = cur;
                count = 1;
            }
        }
        return count;
    }

}
