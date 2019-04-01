/**
 * Counting Bits
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
package com.chang.leetcode;

public class Problem338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if(0 == num) {
            res[0] = 0;
            return res;
        }
        if(1 == num) {
            res[0] = 0;
            res[1] = 1;
            return res;
        }
        res[1] = 1;
        int base = 1;
        for (int i = 2; i <= num; i++) {
            if (i >= 2 * base) {
                base *= 2;
            }
            res[i] = 1 + res[i - base];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem338 problem = new Problem338();
        System.out.println(problem.countBits(2).toString());
        System.out.println(problem.countBits(5).toString());
    }
}
