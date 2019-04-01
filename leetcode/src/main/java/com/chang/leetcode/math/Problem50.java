/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
package com.chang.leetcode.math;

import com.chang.leetcode.Problem16;

public class Problem50 {

    public double myPow(double x, int n) {
        if( n < 0) {
            n = -n;
            x = 1/x;
        }
        return powPos(x, n);
    }

    private double powPos(double x, int n) {
        double temp = x;
        if (n == 0)
            return 1;
        temp = powPos(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else {
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        double zero = Double.MIN_VALUE * 2;
        Problem50 problem = new Problem50();
        System.out.println(problem.myPow(2.00000, 10));
        System.out.println(problem.myPow(2.00000, 10) - 1024.00000d < zero);
        System.out.println(problem.myPow(2.10000, 3));
        System.out.println(problem.myPow(2.10000, 3) - 9.26100 < zero);
        System.out.println(problem.myPow(2.00000, -2));
        System.out.println(problem.myPow(2.00000, -2) - 0.25000 < zero);
        System.out.println(problem.myPow(0.44894, -5));
        System.out.println(problem.myPow(-2.00000, 2));
        System.out.println(problem.myPow(0.00001, 2147483647));

    }

    public double myPowExample(double x, int n) {
        double temp = x;
        if (n == 0)
            return 1;
        temp = myPowExample(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else {
            if (n > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
