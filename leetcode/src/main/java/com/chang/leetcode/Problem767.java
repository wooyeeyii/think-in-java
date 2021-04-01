/*
 * 767. Reorganize String
 *
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 *
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 *
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem767 {

    public String reorganizeStringWithMap(String s) {
        int sum = s.length(), max = 0;
        char c = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            map.put(d, map.getOrDefault(d, 0) + 1);
            if (map.get(d) > max) {
                max = map.get(d);
                c = d;
            }
        }
        map.remove(c);

        if (sum - max < max - 1) {
            return "";
        }

        char[] chars = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < max; i++) {
            chars[idx] = c;
            idx += 2;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                if (idx < s.length()) {
                    chars[idx] = entry.getKey();
                    idx += 2;
                } else {
                    chars[1] = entry.getKey();
                    idx = 3;
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Problem767 problem = new Problem767();
        System.out.println(problem.reorganizeString("vvvlo"));
        System.out.println(problem.reorganizeString("aab"));
        System.out.println(problem.reorganizeString("aaab"));
        System.out.println(problem.reorganizeString("aaaaabbccc"));
    }

    // without map
    public String reorganizeString(String s) {
        int len = s.length(), max = 0;
        char c = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            cnt[d - 'a']++;
            if (cnt[d - 'a'] > max) {
                max = cnt[d - 'a'];
                c = d;
            }
        }
        cnt[c - 'a'] = 0;

        if (len - max < max - 1) {
            return "";
        }

        char[] chars = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < max; i++) {
            chars[idx] = c;
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            char d = (char) (i + 'a');
            for (int j = 0; j < cnt[i]; j++) {
                if (idx < s.length()) {
                    chars[idx] = d;
                    idx += 2;
                } else {
                    chars[1] = d;
                    idx = 3;
                }
            }
        }
        return String.valueOf(chars);
    }

}
