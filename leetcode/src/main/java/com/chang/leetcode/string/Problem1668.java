/*
 * 1668. Maximum Repeating Substring
 *
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
 * The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
 * If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 *
 * Example 1:
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 *
 * Example 2:
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 *
 * Example 3:
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 *
 * Constraints:
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence and word contains only lowercase English letters.
 */
package com.chang.leetcode.string;

public class Problem1668 {

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        int idx = sequence.indexOf(word);
        while (-1 != idx) {
            String left = sequence.substring(idx + word.length());
            int cnt = leftRepeat(left, word);
            max = Math.max(max, 1 + cnt);

            sequence = left.substring(word.length() * cnt);
            idx = sequence.indexOf(word);
        }

        return max;
    }

    private int leftRepeat(String left, String word) {
        int cnt = 0;
        int idx = left.indexOf(word);
        while (idx == 0) {
            cnt++;
            left = left.substring(word.length());
            idx = left.indexOf(word);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem1668 problem = new Problem1668();
        System.out.println(problem.maxRepeating("abab", "b"));
        System.out.println(problem.maxRepeating("aaa", "a"));
    }

    public int maxRepeatingExample(String sequence, String word) {
        int cnt = 1;
        String repeatStr = word;
        while (sequence.contains(repeatStr)) {
            cnt++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(word);
            }
            repeatStr = sb.toString();
        }
        return cnt - 1;
    }


}
