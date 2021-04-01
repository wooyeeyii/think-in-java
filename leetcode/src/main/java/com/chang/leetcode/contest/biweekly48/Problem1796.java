/*
 * 1796. Second Largest Digit in a String
 *
 * Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
 * An alphanumeric string is a string consisting of lowercase English letters and digits.
 *
 * Example 1:
 * Input: s = "dfa12321afd"
 * Output: 2
 * Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
 *
 * Example 2:
 * Input: s = "abc1111"
 * Output: -1
 * Explanation: The digits that appear in s are [1]. There is no second largest digit.
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 */
package com.chang.leetcode.contest.biweekly48;

public class Problem1796 {

    public int secondHighest(String s) {
        // a < b
        int a = -1, b = -1;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                int d = c - '0';
                if (-1 == b) {
                    b = d;
                } else if (d != b && d > a) {
                    a = Math.min(b, d);
                    b = Math.max(b, d);

                }
            }
        }

        return a == b ? -1 : Math.min(a, b);
    }

    public static void main(String[] args) {
        Problem1796 problem = new Problem1796();
        System.out.println(problem.secondHighest("dfa12321afd"));
        System.out.println(problem.secondHighest("ck077"));
        System.out.println(problem.secondHighest("abc1111"));
        System.out.println(problem.secondHighest("dfa12321afd"));
    }

}
