/*
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1
 * when the division result overflows.
 */
package com.chang.leetcode.math;

public class Problem29 {

    public int divide(int dividend, int divisor) {
        boolean flag = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long remain = a;
        long result = 0;
        while (remain >= b) {
            long sum = b;
            long count = 0;
            while (sum <= remain) {
                count++;
                sum = b << count;
            }
            if (sum > remain) {
                count--;
                sum = b << count;
            }
            result += 1L << count;
            remain -= sum;
        }
        /*错误的*/
        /*if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return flag? (int)result : -(int)result;*/

        result = flag ? result : -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
