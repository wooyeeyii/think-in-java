/*
 * 858. Mirror Reflection
 *
 * There is a special square room with mirrors on each of the four walls.  Except for the southwest corner,
 * there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 *
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 *
 * Example 1:
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 *
 * Note:
 * 1 <= p <= 1000
 * 0 <= q <= p
 */
package com.chang.leetcode.math;

public class Problem858 {

    public int mirrorReflection(int p, int q) {
        if (0 == q) {
            return 0;
        }

        // 最大公约数
        // q <= p
        int a = Math.max(p, q), b = Math.min(p, q);
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        // 最大公约数就是a
        // 最小公倍数就是p * q / a;
        int d = p * q / a;

        /*
         * So, this problem can be transformed into finding m * p = n * q, where
         * m = the number of room extension.
         * n = the number of light reflection.
         */
        int m = d / p;
        int n = d / q;

        if (n % 2 == 0) {
            // -1 or 2
            if (m % 2 == 0) {
                return -1;
            } else {
                return 2;
            }
        } else {
            // o or 1
            if (m % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }

    }

    public static void main(String[] args) {
        Problem858 problem = new Problem858();
        // 1
        System.out.println(problem.mirrorReflection(3, 1));
        // 2
        System.out.println(problem.mirrorReflection(2, 1));
    }

}
