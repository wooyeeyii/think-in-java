/*
 * 241. Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<String> polandStr = poland(input);
        if (null == polandStr) {
            return new ArrayList<Integer>();
        }
        return diffWaysToComputeRec(polandStr);
    }

    private List<Integer> diffWaysToComputeRec(List<String> polandStr) {
        List<Integer> ret = new ArrayList<>();
        if (1 == polandStr.size()) {
            ret.add(Integer.valueOf(polandStr.get(0)));
            return ret;
        }
        for (int i = 2; i < polandStr.size(); i += 2) {
            List<Integer> preSub = diffWaysToComputeRec(polandStr.subList(0, i - 1));
            List<Integer> endSub = diffWaysToComputeRec(polandStr.subList(i, polandStr.size()));
            final int idx = i;
            preSub.forEach(a -> {
                endSub.forEach(b -> {
                    ret.add(cal(a, b, polandStr.get(idx - 1)));
                });
            });

        }
        return ret;
    }

    public int cal(int a, int b, String c) {
        switch (c) {
            case "+":
                return (a + b);
            case "-":
                return (a - b);
            case "*":
                return (a * b);
            case "/":
                return (a / b);
            default:
                break;
        }
        return 0;
    }

    public List<String> poland(String str) {
        if (str == null || str.length() <= 0) return null;
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

    public static void main(String[] args) {
        Problem241 problem = new Problem241();
        System.out.println(ArrayToStringUtil.oneDimension(problem.diffWaysToComputeDP("2-1-1")));
        System.out.println("######################");

        System.out.println(ArrayToStringUtil.oneDimension(problem.diffWaysToCompute("2*3-4*5")));
        System.out.println("######################");


    }


    List<Integer>[][] dp = null;

    public List<Integer> diffWaysToComputeDP(String input) {
        int n = input.length();
        dp = new ArrayList[n][n];
        eval(input, 0, n - 1);
        return dp[0][n - 1];
    }

    private void eval(String s, int i, int j) {
        if (dp[i][j] != null) return;
        dp[i][j] = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            char op = s.charAt(k);
            if (op == '+' || op == '-' || op == '*') {
                eval(s, 0, k - 1);
                eval(s, k + 1, j);
                for (int val1 : dp[i][k - 1])
                    for (int val2 : dp[k + 1][j])
                        res.add(calc(val1, op, val2));
            }
        }
        if (res.isEmpty()) {
            dp[i][j].add(Integer.valueOf(s.substring(i, j + 1)));
            return;
        }
        dp[i][j] = res;
    }

    private int calc(int n1, char op, int n2) {
        //System.out.println("n1 = "+n1+" n2 = "+ n2);
        if (op == '+')
            return n1 + n2;
        else if (op == '-')
            return n1 - n2;
        else if (op == '*')
            return n1 * n2;
        return 0;
    }

}
