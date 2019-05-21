/**
 * 306. Additive Number
 * <p>
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 * each subsequent number in the sequence must be the sum of the preceding two.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * Example 2:
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
package com.chang.leetcode;

public class Problem306 {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= len / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            for (int j = 1;  Math.max(j, i) <= len - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                String a = num.substring(0, i);
                String b = num.substring(i, i + j);
                if (addCor(num, a, b, i + j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean addCor(String num, String a, String b, int bE) {
        int end = bE;
        String c = null;
        String next = null;
        while (end < num.length()) {
            c = stringAdd(a, b);
            end = bE + c.length();
            next = num.substring(bE, Math.min(num.length(), end));
            if (!next.equals(c)) {
                return false;
            }

            a = b;
            b = next;
            bE = end;
        }
        if(next.equals(c)) {
            return true;
        }
        return false;
    }

    private String stringAdd(String a, String b) {
        Long ai = Long.valueOf(a);
        Long bi = Long.valueOf(b);
        Long ci = Long.valueOf(ai + bi);
        return String.valueOf(ci);
    }

    public static void main(String[] args) {
        Problem306 problem = new Problem306();
        System.out.println(problem.isAdditiveNumber("112358"));
        System.out.println(problem.isAdditiveNumber("199100199"));
        System.out.println(problem.isAdditiveNumber("1203"));
        System.out.println(problem.isAdditiveNumber("0235813"));
    }

}
