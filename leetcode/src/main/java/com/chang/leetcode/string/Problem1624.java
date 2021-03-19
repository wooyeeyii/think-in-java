/*
 * 1624. Largest Substring Between Two Equal Characters
 *
 * Given a string s, return the length of the longest substring between two equal characters,
 * excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 *
 * Example 2:
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 *
 * Example 3:
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 *
 * Example 4:
 * Input: s = "cabbac"
 * Output: 4
 * Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 *
 * Example 5:
 * Input: s = "abacada"
 * Output: 5
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 */
package com.chang.leetcode.string;

import java.util.Arrays;

public class Problem1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] pos = new int[26];
        int max = -1;
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (-1 == pos[c - 'a']) {
                pos[c - 'a'] = i;
            } else {
                max = Math.max(max, i - pos[c - 'a'] - 1);
            }
        }
        return max;
    }

}
