/**
 * 227. Basic Calculator II
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 *
 * Note:
 *     You may assume that the given expression is always valid.
 *     Do not use the eval built-in library function.
 */
package com.chang.leetcode;

public class Problem227 {
    public int calculate(String s) {
        // 替换所有的空格
        s.replaceAll(" ", "");
        String[] numbers = s.split("[\\+\\-\\*\\/]");

        return 0;
    }

    public static void main(String[] args) {
        Problem227 problem = new Problem227();
        System.out.println(problem.calculate(" 3/2+2*5-4"));
    }

}
