/**
 * 318. Maximum Product of Word Lengths
 * <p>
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will contain
 * only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * <p>
 * Example 2:
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * <p>
 * Example 3:
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
package com.chang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem318 {

    /**
     * 核心思想，如何类比提高比较效率
     */
    public int maxProduct(String[] words) {
        int len = words.length;
        int max = 0;
        int[] replica = new int[len];
        for (int i = 0; i < len; i++) {
            int r = 0;
            for (int j = 0; j < words[i].length(); j++) {
                r |= 1 << (words[i].charAt(j) - 'a');
            }
            replica[i] = r;
        }

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if( (replica[i] & replica[j]) == 0) {
                    int mul = words[i].length() * words[j].length();
                    max = Math.max(max, mul);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem318 problem = new Problem318();
        String[] str1 = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(16 == problem.maxProduct(str1));
        String[] str2 = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(4 == problem.maxProduct(str2));
        String[] str3 = new String[]{"a", "aa", "aaa", "aaaa"};
        System.out.println(0 == problem.maxProduct(str3));
    }


}
