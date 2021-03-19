/*
 * 738. Monotone Increasing Digits
 *
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 *
 * Example 1:
 * Input: N = 10
 * Output: 9
 *
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 *
 * Example 3:
 * Input: N = 332
 * Output: 299
 *
 * Note: N is an integer in the range [0, 10^9].
 */
package com.chang.leetcode;

public class Problem738 {

    public int monotoneIncreasingDigitsSelf(int n) {
        String s = String.valueOf(n);
        int i = 0, lastDouble = -1;
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                break;
            } else if (s.charAt(i) == s.charAt(i + 1) && (-1 == lastDouble || s.charAt(i) != s.charAt(lastDouble))) {
                lastDouble = i;
            }
        }

        if (i == s.length() - 1) {
            return n;
        }

        i = -1 == lastDouble ? i : (s.charAt(lastDouble) == s.charAt(i) ? lastDouble : i);

        int res = 0;
        for (int j = 0; j < i; j++) {
            res *= 10;
            res += s.charAt(j) - '0';
        }
        res = res * 10 + (s.charAt(i) - '0' - 1);
        for (int j = i + 1; j < s.length(); j++) {
            res = res * 10 + 9;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem738 problem = new Problem738();
        // 667999
        System.out.println(problem.monotoneIncreasingDigits(668841));
        // 9
        System.out.println(problem.monotoneIncreasingDigits(10));
        // 1234
        System.out.println(problem.monotoneIncreasingDigits(1234));
        // 1233
        System.out.println(problem.monotoneIncreasingDigits(1233));
        // 299
        System.out.println(problem.monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int i = 0;
        int idx = 0;
        while (i < s.length() - 1 && s.charAt(i) <= s.charAt(i + 1)) {
            if (s.charAt(i) <= s.charAt(i + 1) - 1) {
                idx = i + 1;
            }
            i++;
        }

        if (i == s.length() - 1) {
            return n;
        }

        i = idx;
        int res = 0;
        for (int j = 0; j < i; j++) {
            res *= 10;
            res += s.charAt(j) - '0';
        }
        res = res * 10 + (s.charAt(i) - '0' - 1);
        for (int j = i + 1; j < s.length(); j++) {
            res = res * 10 + 9;
        }
        return res;
    }

}
