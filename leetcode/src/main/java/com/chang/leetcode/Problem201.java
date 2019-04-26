/**
 * 201. Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 * Input: [5,7]
 * Output: 4
 *
 * Example 2:
 * Input: [0,1]
 * Output: 0
 */
package com.chang.leetcode;

public class Problem201 {

    public int rangeBitwiseAnd(int m, int n) {
        int mC = bitCount(m);
        int nC = bitCount(n);
        if(mC != nC) {
            return 0;
        }
    }

    private int bitCount(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem201 problem = new Problem201();
        System.out.println(4 == problem.rangeBitwiseAnd(5, 7));
        System.out.println(0 == problem.rangeBitwiseAnd(0, 1));
    }


}
