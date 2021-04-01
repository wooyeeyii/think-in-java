/*
 * 991. Broken Calculator
 *
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 *
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 *
 * Return the minimum number of operations needed to display the number Y.
 *
 * Example 1:
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 *
 * Example 2:
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 *
 * Example 3:
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 *
 * Example 4:
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 *
 * Note:
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 *
 */
package com.chang.leetcode.math;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem991 {

    // Time Limit Exceed
    public int brokenCalcTooSlow(int x, int y) {
        if (y <= x) {
            return x - y;
        }

        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        Set<Integer> set = new HashSet<>();
        q.add(x);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int m = q.poll();
                if (set.contains(m)) {
                    continue;
                }

                if (m - 1 == y || 2 * m == y) {
                    return res + 1;
                }

                q.add(m - 1);
                q.add(2 * m);
                set.add(m);
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem991 problem = new Problem991();
        System.out.println(problem.brokenCalc(2, 3));
        System.out.println(problem.brokenCalc(5, 8));
        System.out.println(problem.brokenCalc(3, 10));
        System.out.println(problem.brokenCalc(1024, 1));
    }

    public int brokenCalc(int x, int y) {
        int res = 0;
        while (y > x) {
            y = y % 2 == 0 ? y / 2 : y + 1;
            res++;
        }
        return res + x - y;
    }

}
