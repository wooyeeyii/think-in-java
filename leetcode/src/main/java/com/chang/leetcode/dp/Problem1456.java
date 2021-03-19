/*
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string s and an integer k.
 * Return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are (a, e, i, o, u).
 *
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 * Example 4:
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 *
 * Example 5:
 * Input: s = "tryhard", k = 4
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
package com.chang.leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class Problem1456 {

    private static final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    private boolean isVowel(char c) {
        return vowels.contains(c);
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < k; i++) {
            dp[i] = ((i - 1 < 0) ? 0 : dp[i - 1]) + (isVowel(s.charAt(i)) ? 1 : 0);
            max = Math.max(max, dp[i]);
        }

        for (int i = k; i < len; i++) {
            dp[i] = dp[i - 1] + (isVowel(s.charAt(i)) ? 1 : 0) - (isVowel(s.charAt(i - k)) ? 1 : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem1456 problem = new Problem1456();
        System.out.println(3 == problem.maxVowels("abciiidef", 3));
        System.out.println(2 == problem.maxVowels("aeiou", 2));
        System.out.println(2 == problem.maxVowels("leetcode", 3));
        System.out.println(0 == problem.maxVowels("rhythms", 4));
        System.out.println(1 == problem.maxVowels("tryhard", 4));
    }

    public int maxVowelsExample(String s, int k) {
        int result = 0;
        String str = s.substring(0, k);
        for (int i = 0; i < k; i++) {
            if (isVowel(str.charAt(i))) {
                result++;
            }
        }
        if (result == s.length()) {
            return result;
        }
        int num = result;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                num++;
            }
            if (isVowel(s.charAt(i - k))) {
                num--;
            }
            result = Math.max(num, result);
        }
        return result;
    }

}
