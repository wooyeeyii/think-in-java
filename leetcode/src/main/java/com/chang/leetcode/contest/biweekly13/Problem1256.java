/*
 * 1256. Encode Number
 *
 * Given a non-negative integer num, Return its encoding string.
 *
 * The encoding is done by converting the integer to a string using a secret function that you should deduce from the following table:
 * f(0) = ""
 * f(1) = "0"
 * f(2) = "1"
 * f(3) = "00"
 * f(4) = "01"
 * f(5) = "10"
 * f(6) = "11"
 * f(7) = "000"
 *
 * Example 1:
 * Input: num = 23
 * Output: "1000"
 *
 * Example 2:
 * Input: num = 107
 * Output: "101100"
 *
 * Constraints:
 *
 * 0 <= num <= 10^9
 */
package com.chang.leetcode.contest.biweekly13;

public class Problem1256 {

    // grey code
    public String encode(int num) {
        if (num == 0) {
            return "";
        }

        int count = getBits(num);

        String s = "";
        int left = num;
        while (left > 0) {
            int half = (1 << count) - 1 + (1 << (count - 1)) - 1;
            int a = left <= half ? 0 : 1;
            if (a == 0) {
                left = left - (1 << count) + (1 << (count - 1));
            } else {
                left = left - half + (1 << (count - 1)) - 2;
            }
            count--;

            s += String.valueOf(a);
        }

        return s;
    }

    // 等比数列求和 2^0 + 2^1 + 2^2 + ...      2^(n + 1) - 1;
    private int getBits(int num) {
        int count = 0;
        while (((1 << count) - 1) <= num) {
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        Problem1256 problem = new Problem1256();
        System.out.println("11".equals(problem.encode(6)));
        System.out.println("001".equals(problem.encode(8)));
        System.out.println("1000".equals(problem.encode(23)));
        System.out.println("101100".equals(problem.encode(107)));

    }

    /*
     * Solution 1: Recursion idea
     * The following sequence can be built up form the ealier result.
     * So I search index of the prefix part
     * For example:
     * f(5) = "10"
     * f(6) = "11"
     * The prefix are both f(2) = "1"
     *
     * so we found that f(n) has f((n - 1) / 2) as prefix.
     */
    public String encodeExample1(int n) {
        return n > 0 ? encodeExample1((n - 1) / 2) + "10".charAt(n % 2) : "";
    }

    /*
     * Solution 2: Binary of n + 1
     * Assume g(n) = "1" + f(n)
     * we can find:
     * g(0) = "1" g(1) = "10" g(2) = "111" g(3) = "100" g(4) = "101" g(5) = "110" g(6) = "111"
     *
     * Now everything is obvious:
     * g(n) = binary(n + 1)
     * "1" + f(n) = binary(n + 1)
     * f(n) = binary(n + 1).substring(1)
     */
    public String encodeExample2(int n) {
        return Integer.toBinaryString(n + 1).substring(1);
    }

}
