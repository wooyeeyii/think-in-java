/**
 * 1201. Ugly Number III
 * <p>
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive integers which are divisible by a or b or c.
 * <p>
 * Example 1:
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * <p>
 * Example 2:
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 12... The 4th is 6.
 * <p>
 * Example 3:
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 * <p>
 * Example 4:
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 * <p>
 * Constraints:
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * It's guaranteed that the result will be in range [1, 2 * 10^9]
 */
package com.chang.leetcode.contest.weekly155;

public class Problem1201 {

    public int nthUglyNumberTooSlow(int n, int a, int b, int c) {
        long result = 0;
        long aCur = 1;
        long bCur = 1;
        long cCur = 1;
        for (int i = 0; i < n; i++) {
            long min = Math.min(aCur * a, Math.min(bCur * b, cCur * c));
            result = min;
            if (aCur * a == min) {
                aCur++;
            }
            if (bCur * b == min) {
                bCur++;
            }
            if (cCur * c == min) {
                cCur++;
            }
        }
        return (int) result;
    }

    public int nthUglyNumberTooSlow2(int n, int a, int b, int c) {
        int count = 0;
        int cur = 1;
        while (count < n) {
            if (cur % a == 0 || cur % b == 0 || cur % c == 0) {
                count++;
            }
            cur++;
        }
        return cur - 1;
    }

    public static void main(String[] args) {
        Problem1201 problem = new Problem1201();
        System.out.println(4 == problem.nthUglyNumber(3, 2, 3, 5));
        System.out.println(6 == problem.nthUglyNumber(4, 2, 3, 4));
        System.out.println(10 == problem.nthUglyNumber(5, 2, 11, 13));
        System.out.println(1999999984 == problem.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    private long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private int count(int num, int a, int b, int c) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }

    // Calculate how many numbers from 1 to num are divisible by either a, b or c by using the formula:
    // (num / a) + (num / b) + (num / c) – (num / lcm(a, b)) – (num / lcm(b, c)) – (num / lcm(a, c)) + (num / lcm(a, b, c))
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = Integer.MAX_VALUE, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
