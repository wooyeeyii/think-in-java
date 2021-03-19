/*
 * 394. Decode String
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside
 * the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only
 * for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
package com.chang.leetcode;

import java.util.Stack;

public class Problem394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int leaves = 0;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            if (s.charAt(pos) == '[') {
                stack.push(sb.toString());
                leaves++;
                sb = new StringBuilder();
            } else if (s.charAt(pos) == ']') {
                StringBuilder tmp = new StringBuilder();
                String countStr = stack.pop();
                int digIdx = 0;
                for (char c : countStr.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        break;
                    }
                    digIdx++;
                }
                int count = Integer.valueOf(countStr.substring(digIdx));
                for (int i = 0; i < count; i++) {
                    tmp.append(sb);
                }
                leaves--;
                if (digIdx > 0 || leaves > 0) {
                    tmp.insert(0, countStr.substring(0, digIdx));
                    sb = tmp;
                } else {
                    stack.push(tmp.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s.charAt(pos));
            }
            pos++;
        }

        res.append(sb.toString());
        while (stack.size() > 0) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Problem394 problem = new Problem394();
        System.out.println("aaabcbc".equals(problem.decodeString("3[a]2[bc]")));
        System.out.println("accaccacc".equals(problem.decodeString("3[a2[c]]")));
        System.out.println("abcabccdcdcdef".equals(problem.decodeString("2[abc]3[cd]ef")));
        System.out.println((problem.decodeString("1[a2[b3[c4[d]]]]")));
        System.out.println((problem.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")));
    }
}
