/*
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
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem227 {

    public int calculate(String s) {
        List list = poland(s);
        List inverse = reversePoland(list);
        return calPoland(inverse);
    }

    // 波兰式 中缀表达式
    public List poland(String str) {
        if (str == null) return null;
        String s = str.replaceAll("[ ]", "");
        List<String> list = new ArrayList();

        int num = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {         // if c is digit, add up the number
                num = 10 * num + (int) (c - '0');
            } else {
                if (Character.isDigit(s.charAt(i - 1))) {
                    list.add(String.valueOf(num));
                    num = 0;
                }
                list.add(String.valueOf(c));
            }
        }
        if (Character.isDigit(s.charAt(s.length() - 1))) {
            list.add(String.valueOf(num));
        }
        return list;
    }

    // 逆波兰式 后缀表达式
    public List reversePoland(List<String> list) {
        if (list == null) return null;
        List<String> inverse = new ArrayList<>();
        Stack<String> stack = new Stack();
        list.forEach(s -> {
            if (isSymbol(s)) {
                if ("(".equals(s)) {
                    stack.push(s);
                } else if (")".equals(s)) {
                    while (!"(".equals(stack.peek())) {
                        inverse.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (stack.size() > 0 && getPriority(s) > getPriority(stack.peek())) {
                        stack.push(s);
                    } else {
                        while (stack.size() > 0 && getPriority(stack.peek()) >= getPriority(s)) {
                            inverse.add(stack.pop());
                        }
                        stack.push(s);
                    }
                }
            } else {
                inverse.add(s);
            }
        });
        while (stack.size() > 0) {
            inverse.add(stack.pop());
        }
        return inverse;
    }

    // calculate
    public int calPoland(List<String> inverse) {
        if (null == inverse || inverse.size() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < inverse.size(); i++) {
            if (isSymbol(inverse.get(i))) {
                int b = stack.pop();
                int a = stack.pop();
                switch (inverse.get(i)) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(inverse.get(i)));
            }
        }
        return stack.pop();
    }

    private boolean isSymbol(String s) {
        if (null == s || s.length() != 1) {
            return false;
        }

        char c = s.charAt(0);
        if ('+' == c || '-' == c || '*' == c || '/' == c || '(' == c || ')' == c) {
            return true;
        }
        return false;
    }

    // >= true
    private int getPriority(String s) {
        if (null == s || s.length() != 1) {
            return 0;
        }

        char value = s.charAt(0);
        switch (value) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Problem227 problem = new Problem227();
        List list = problem.poland(" 32 / 21+ 2 * ( 5 - 4) + 2");
        System.out.println(ArrayToStringUtil.oneDimension(list));
        List inverse = problem.reversePoland(list);
        System.out.println(ArrayToStringUtil.oneDimension(inverse));
        System.out.println(problem.calPoland(inverse));

        System.out.println(problem.calculate(" 3/2+2*5-4"));
    }

    public int calculateExample(String s) {
        if (s == null) return 0;

        int left = 0, num = 0, opt = 0, res = 0;
        int sign = 1;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {         // if c is digit, add up the number
                num = 10 * num + (int) (c - '0');
            } else {                            // c is +-*/
                if (opt == 1) num = left * num;     // if operator was */, do the calculation
                if (opt == -1) num = left / num;
                opt = 0;    // clear the operator

                if (c == '+' || c == '-') {         // c is +-, so result can be updated
                    res += sign * num;
                    sign = c == '+' ? 1 : -1;       // update the last sign
                } else if (c == '*' || c == '/') {
                    left = num;                     // update the number to the left of * or /
                    opt = c == '*' ? 1 : -1;        // 1 -> *, -1 -> /
                }

                num = 0;    // just see an operator, have to clear the number
            }
        }

        // for the last number
        if (opt == 1)           // * n at the end
            res += sign * left * num;
        else if (opt == -1)     // / n at the end
            res += sign * left / num;
        else                    // +- n at the end
            res += sign * num;

        return res;
    }

}
