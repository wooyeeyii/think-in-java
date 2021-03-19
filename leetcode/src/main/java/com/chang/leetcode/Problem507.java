/*
 * 507. Perfect Number
 *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
package com.chang.leetcode;

public class Problem507 {

    public boolean checkPerfectNumber(int num) {
        if (0 >= num) return false;

        long sum = 1;
        int half = (int) Math.sqrt(num);
        for (int i = 2; i <= half; i++) {
            if (0 == num % i) {
                sum += (i + num / i);
            }
        }
        if (num == half * half) {
            sum -= half;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Problem507 problem = new Problem507();
        System.out.println(problem.checkPerfectNumber(28));
        System.out.println(problem.checkPerfectNumber(6));
    }

}
