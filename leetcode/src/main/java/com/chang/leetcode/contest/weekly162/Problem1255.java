/*
 * 1255. Maximum Score Words Formed by Letters
 *
 * Given a list of words, list of  single letters (might be repeating) and score of every character.
 * Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
 * It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z'
 * is given by score[0], score[1], ... , score[25] respectively.
 *
 * Example 1:
 * Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * Output: 23
 * Explanation:
 * Score  a=1, c=9, d=5, g=3, o=2
 * Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
 * Words "dad" and "dog" only get a score of 21.
 *
 * Example 2:
 * Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
 * Output: 27
 * Explanation:
 * Score  a=4, b=4, c=4, x=5, z=10
 * Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
 * Word "xxxz" only get a score of 25.
 *
 * Example 3:
 * Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
 * Output: 0
 * Explanation:
 * Letter "e" can only be used once.
 *
 * Constraints:
 *
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length == 26
 * 0 <= score[i] <= 10
 * words[i], letters[i] contains only lower case English letters.
 */
package com.chang.leetcode.contest.weekly162;

import java.util.Arrays;

public class Problem1255 {

    int max = 0;
    int[] score = null;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score;
        int[] charNumber = new int[26];
        for (char c : letters) {
            charNumber[c - 'a'] += 1;
        }

        dfs(words, 0, charNumber, 0);
        return max;
    }

    private void dfs(String[] words, int index, int[] charNumber, int cur) {
        max = Math.max(max, cur);

        if (words == null || words.length - 1 < index) return;

        for (int i = index; i < words.length; i++) {
            int[] charNumberNext = canFitIn(words[i], charNumber);
            if (null != charNumberNext) {
                int next = cur;
                for (char c : words[i].toCharArray()) {
                    next += score[c - 'a'];
                }
                dfs(words, i + 1, charNumberNext, next);
            }
        }
    }

    private int[] canFitIn(String word, int[] charNumber) {
        int[] charNumberNext = Arrays.copyOf(charNumber, charNumber.length);
        for (char c : word.toCharArray()) {
            if (charNumberNext[c - 'a'] > 0) {
                charNumberNext[c - 'a'] -= 1;
            } else {
                return null;
            }
        }
        return charNumberNext;
    }

    public static void main(String[] args) {
        Problem1255 problem = new Problem1255();
        System.out.println(23 == problem.maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        problem.max = 0;
        System.out.println(27 == problem.maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx"},
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));

        problem.max = 0;
        System.out.println(0 == problem.maxScoreWords(new String[]{"leetcode"},
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
    }
}
