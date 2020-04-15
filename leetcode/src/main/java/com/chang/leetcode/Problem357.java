/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding 11,22,33,44,55,66,77,88,99
 */
package com.chang.leetcode;

public class Problem357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return 0;
        }
        if (0 == n) {
            return 1;
        }
        int count = 10;
        for (int i = 2; i <= n; i++) {
            count += 9 * A(9, i - 1);
        }
        return count;
    }

    private int A(int n, int m) {
        if (m > n || m == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < m; i++) {
            count *= (n - i);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem357 problem = new Problem357();
        System.out.println(1 == problem.countNumbersWithUniqueDigits(0));
        System.out.println(10 == problem.countNumbersWithUniqueDigits(1));
        System.out.println(91 == problem.countNumbersWithUniqueDigits(2));
    }
}
