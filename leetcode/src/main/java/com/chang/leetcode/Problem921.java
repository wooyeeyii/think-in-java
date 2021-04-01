/*
 * 921. Minimum Add to Make Parentheses Valid
 *
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
 * so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * Example 1:
 * Input: "())"
 * Output: 1
 *
 * Example 2:
 * Input: "((("
 * Output: 3
 *
 * Example 3:
 * Input: "()"
 * Output: 0
 *
 * Example 4:
 * Input: "()))(("
 * Output: 4
 *
 *
 * Note:
 *
 * S.length <= 1000
 * S only consists of '(' and ')' characters.
 */
package com.chang.leetcode;

public class Problem921 {

    // count '(' and ')'
    // reference awesome solution see below: leftCnt++, leftCnt--
    public int minAddToMakeValidSelf(String s) {
        int leftCnt = 0, rightCnt = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftCnt++;
            } else if (')' == c) {
                rightCnt++;
            }

            if (rightCnt > leftCnt) {
                cnt++;
                leftCnt++;
            }
        }

        return cnt + (leftCnt - rightCnt);
    }

    public static void main(String[] args) {
        Problem921 problem = new Problem921();
        System.out.println(problem.minAddToMakeValid("())"));
        System.out.println(problem.minAddToMakeValid("((("));
        System.out.println(problem.minAddToMakeValid("()"));
        System.out.println(problem.minAddToMakeValid("())"));
        System.out.println(problem.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String s) {
        int leftCnt = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftCnt++;
            } else if (')' == c) {
                leftCnt--;
            }

            if (leftCnt < 0) {
                cnt++;
                leftCnt++;
            }
        }

        return cnt + leftCnt;
    }

}
