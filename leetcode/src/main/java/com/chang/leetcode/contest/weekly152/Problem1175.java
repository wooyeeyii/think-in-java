/**
 * 1175. Prime Arrangements
 *
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 *
 * (Recall that an integer is prime if and only if it is greater than 1,
 * and cannot be written as a product of two positive integers both smaller than it.)
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
 *
 * Example 2:
 * Input: n = 100
 * Output: 682289015
 *
 * Constraints:
 * 1 <= n <= 100
 */
package com.chang.leetcode.contest.weekly152;

public class Problem1175 {

    public int numPrimeArrangements(int n) {
        int c = (int)Math.pow(10, 9) + 7;
        int primeNumber = countPrimeNumber(n);

        long mulS = 1;
        int min = Math.min(primeNumber, n - primeNumber);
        int max = Math.max(primeNumber, n - primeNumber);
        for(int i = 1; i <= min; i++) {
            mulS = (mulS * i) % c;
        }
        long mulB = mulS * mulS % c;
        for(int j = min + 1; j <= max; j++ ) {
            mulB = (mulB * j) % c;
        }
        return (int)mulB;
    }

    private int countPrimeNumber(int n) {
        if(n <= 1) return 0;

        int count = 0;
        for(int i = 2; i <= n; i++) {
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                   flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Problem1175 problem = new Problem1175();
        System.out.println(12 == problem.numPrimeArrangements(5));
        System.out.println(682289015 == (problem.numPrimeArrangements(100)));
    }

}
