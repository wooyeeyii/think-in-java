/*
 * 316. Remove Duplicate Letters
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 */
package com.chang.leetcode;

import java.util.Stack;

public class Problem316 {

    public static void main(String[] args) {
        Problem316 problem = new Problem316();
        System.out.println("abc".equals(problem.removeDuplicateLetters("bcabc")));
        System.out.println("acdb".equals(problem.removeDuplicateLetters("cbacdcbc")));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastPos = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        // save last position of letter
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            // if stack already contains letter, continue;
            if (seen[c]) {
                continue;
            }

            // check letter A before c is bigger than c and string has same letter A after c
            // if true, we can use A after c to get a smaller string
            while (!stack.isEmpty() && c < stack.peek() && i < lastPos[stack.peek()]) {
                seen[stack.pop()] = false;
            }

            stack.push(c);
            seen[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : stack) {
            sb.append((char) (n + 'a'));
        }
        return sb.toString();
    }

}
