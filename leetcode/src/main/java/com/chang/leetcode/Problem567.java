/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
package com.chang.leetcode;

public class Problem567 {

    public boolean checkInclusion(String s1, String s2) {
        if(null == s1 || 0 == s1.length()) {
            return true;
        }
        if(null == s2 || 0 == s2.length() || s1.length() > s2.length()) {
            return false;
        }

        int[] flag = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            flag[s1.charAt(i) - 'a'] += 1;
            flag[s2.charAt(i) - 'a'] -= 1;
        }
        if (allZero(flag)) return true;

        for(int i = s1.length(); i < s2.length(); i++) {
            flag[s2.charAt(i) - 'a'] -= 1;
            flag[s2.charAt(i - s1.length()) - 'a'] += 1;
            if(allZero(flag)) return true;
        }
        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem567 problem = new Problem567();
        System.out.println(problem.checkInclusion("ab", "eidbaooo"));
        System.out.println(!problem.checkInclusion("ab", "eidboaoo"));
    }

}
