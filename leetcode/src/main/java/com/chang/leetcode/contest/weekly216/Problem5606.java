/**
 * 1663. Smallest String With A Given Numeric Value
 *
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
 * so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values.
 * For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is,
 * either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 *
 * Example 1:
 * Input: n = 3, k = 27
 * Output: "aay"
 * Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
 *
 * Example 2:
 * Input: n = 5, k = 73
 * Output: "aaszz"
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * n <= k <= 26 * n
 */
package com.chang.leetcode.contest.weekly216;

public class Problem5606 {

    public String getSmallestStringSlow(int n, int k) {
        int lastA = (n + 1) / 2;
        char[] chars = new char[n];
        int sum = 0;
        for (int i = 0; i < lastA; i++) {
            chars[i] = 'a';
            sum += 1;
        }

        for (int i = lastA; i < n; i++) {
            chars[i] = 'z';
            sum += 26;
        }

        while (sum < k && lastA >= 1) {
            if ('z' == chars[lastA - 1]) {
                lastA--;
                continue;
            }

            chars[lastA - 1] += 1;
            sum++;
        }

        while (sum > k && lastA < n) {
            if ('a' == chars[lastA]) {
                lastA++;
                continue;
            }

            chars[lastA] -= 1;
            sum--;
        }

        return String.valueOf(chars);
    }

    // 最后string形如
    // x 个a 0或1个[a-z] y个z
    // x + y + z = k, 且x + 26y + XXX(z代表的数字) = k
    // 求解x, y , z
    public String getSmallestString(int n, int k) {
        k = k - n;
        int num = k / 25;
        int value = k % 25;

        String result = "";
//        result += "a".repeat(n - 1 - num);
//        result += String.valueOf((char) ((int) 'a' + value));
//        result += "z".repeat(num);

        return result;
    }

    public static void main(String[] args) {
        Problem5606 problem = new Problem5606();
        System.out.println(problem.getSmallestString(3, 27));
        System.out.println(problem.getSmallestString(3, 55));
        System.out.println(problem.getSmallestString(5, 73));
    }

}
