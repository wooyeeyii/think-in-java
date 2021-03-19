/*
 * 1271. Hexspeak
 * 
 * A decimal number can be converted to its Hexspeak representation by first converting it to an uppercase hexadecimal string,
 * then replacing all occurrences of the digit 0 with the letter O, and the digit 1 with the letter I.
 * Such a representation is valid if and only if it consists only of the letters in the set {"A", "B", "C", "D", "E", "F", "I", "O"}.
 * 
 * Given a string num representing a decimal integer N, return the Hexspeak representation of N if it is valid, otherwise return "ERROR".
 * 
 * Example 1:
 * Input: num = "257"
 * Output: "IOI"
 * Explanation:  257 is 101 in hexadecimal.
 * 
 * Example 2:
 * Input: num = "3"
 * Output: "ERROR"
 * 
 * Constraints:
 * 1 <= N <= 10^12
 * There are no leading zeros in the given string.
 * All answers must be in uppercase letters.
 */
package com.chang.leetcode.contest.biweekly14;

public class Problem1271 {

    public String toHexspeak(String num) {
        Long value = Long.valueOf(num);

        String res = new String();
        while (value > 0) {
            Long left = value % 16L;
            if (left > 1 && left < 10) {
                return "ERROR";
            }
            res = getString(left.intValue()) + res;
            value = value / 16L;
        }

        return res;
    }

    private String getString(int v) {
        switch (v) {
            case 15:
                return "F";
            case 14:
                return "E";
            case 13:
                return "D";
            case 12:
                return "C";
            case 11:
                return "B";
            case 10:
                return "A";
            case 1:
                return "I";
            case 0:
                return "O";
        }

        return null;
    }

    public static void main(String[] args) {
        Problem1271 problem = new Problem1271();
        System.out.println("IOI".equals(problem.toHexspeak("257")));
        System.out.println("ERROR".equals(problem.toHexspeak("3")));
    }
}
