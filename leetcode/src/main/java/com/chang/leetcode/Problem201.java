/*
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
        String ms = intToBinaryStr(m);
        String ns = intToBinaryStr(n);
        if (ms.length() != ns.length()) {
            return 0;
        }
        int res = 0;
        int i = ms.length() - 1;
        while (i >= 0 && (('1' == ms.charAt(i) && '1' == ns.charAt(i)) ||
                ('0' == ms.charAt(i) && '0' == ns.charAt(i)))) {
            if ('1' == ms.charAt(i)) {
                res = res + (1 << i);
            }
            i--;
        }
        return res;
    }

    private String intToBinaryStr(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n >> 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem201 problem = new Problem201();
        System.out.println(4 == problem.rangeBitwiseAnd(5, 7));
        System.out.println(0 == problem.rangeBitwiseAnd(0, 1));
        System.out.println(1 == problem.rangeBitwiseAnd(1, 1));
        System.out.println(2 == problem.rangeBitwiseAnd(2, 2));
        System.out.println(6 == problem.rangeBitwiseAnd(6, 6));
    }


}
