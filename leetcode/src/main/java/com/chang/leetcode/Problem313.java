/*
 * 313. Super Ugly Number
 * 
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * 
 * Example:
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * 
 * Note:
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        result[0] = 1;

        int[] mulIdx = new int[primes.length];
        Arrays.fill(mulIdx, 0);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int mul = primes[j] * result[mulIdx[j]];
                if (mul < min) {
                    min = mul;
                }
            }
            result[i] = min;
            for (int j = 0; j < primes.length; j++) {
                int mul = primes[j] * result[mulIdx[j]];
                if (min == mul) {
                    mulIdx[j] += 1;
                }
            }

        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        Problem313 problem = new Problem313();
        int[] primes1 = new int[]{2, 7, 13, 19};
        System.out.println(32 == problem.nthSuperUglyNumber(12, primes1));
    }

}
