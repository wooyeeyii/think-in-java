/*
 * 1249. Minimum Remove to Make Valid Parentheses
 * 
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * Example 4:
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
package com.chang.leetcode.contest.weekly161;

import java.util.Stack;

public class Problem1249 {

    public String minRemoveToMakeValidSlow(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                if (!stack.isEmpty()) {
                    String tmp = "(" + sb.toString() + ")";
                    stack.pop();
                    stack.push(tmp);
                } else {
                    stack.push(sb.toString());
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        String result = new String();
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (!"(".equals(top) && !")".equals(top)) {
                result = top + result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1249 problem = new Problem1249();
        System.out.println("lee(t(c)o)de".equals(problem.minRemoveToMakeValid("lee(t(c)o)de)")));
        System.out.println("ab(c)d".equals(problem.minRemoveToMakeValid("a)b(c)d")));
        System.out.println("".equals(problem.minRemoveToMakeValid("))((")));
        System.out.println("a(b(c)d)".equals(problem.minRemoveToMakeValid("(a(b(c)d)")));
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }


}
