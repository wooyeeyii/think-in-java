/**
 * 402. Remove K Digits
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that
 * the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * <p>
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * <p>
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
package com.chang.leetcode;

public class Problem402 {

    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        int remain = len - k;

        int start = 0;
        int end = len - remain;
        boolean flag = false;
        for (int i = 0; i < remain; i++) {
            int pos = findMin(num, start, end);
            char c = num.charAt(pos);
            if ('0' != c) flag = true;
            if (flag || '0' != c) {
                sb.append(c);
            }
            start = pos + 1;
            end++;
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    private int findMin(String num, int start, int end) {
        int pos = start;
        for (int i = start; i <= end; i++) {
            if (num.charAt(i) < num.charAt(pos)) {
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Problem402 problem = new Problem402();
        System.out.println("1219".equals(problem.removeKdigits("1432219", 3)));
        System.out.println("200".equals(problem.removeKdigits("10200", 1)));
        System.out.println("0".equals(problem.removeKdigits("10", 2)));
    }

    public String removeKdigitsExample(String num, int k) {
        int digits = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (char c : num.toCharArray()) {
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        int idx = 0;
        while (idx < digits && stack[idx] == '0') {
            idx++;
        }
        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }

}
