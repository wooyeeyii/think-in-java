/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative
 * integers less than or equal to n.
 *
 * Example:
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem233 {

    List<Integer> list = new ArrayList<>();
    {
        list.add(0);
    }

    public int countDigitOne(int m) {
        int sum = 0;
        int bit = 0;
        int n = m;
        while(n > 0) {
            int count = sum;
            int digit = n % 10;
            if(0 == digit) {
                sum = count;
            } else if(1 == digit) {
                sum = bitContainOne(bit) + m % (int)Math.pow(10, bit) + 1 + count;
            } else {
                sum = digit * bitContainOne(bit) + (int)Math.pow(10, bit) + count;
            }

            n = n / 10;
            bit++;
            bitContainOne(bit);
        }
        return sum;
    }

    private int bitContainOne(int bit) {
        if(list.size() > bit) {
            return list.get(bit);
        } else {
            int a = list.get(bit - 1) * 10 + (int)Math.pow(10, bit - 1);
            list.add(a);
        }
        return list.get(bit);
    }

    public static void main(String[] args) {
        Problem233 problem = new Problem233();
        System.out.println(1 == problem.countDigitOne(1));
        System.out.println(1 == problem.countDigitOne(6));
        System.out.println(2 == problem.countDigitOne(10));
        System.out.println(6 == problem.countDigitOne(13));
        System.out.println(21 == problem.countDigitOne(100));
        System.out.println(12 == problem.countDigitOne(20));
//        for(int i = 0; i <= 3; i++)
//            System.out.println(problem.bitContainOne(i));
    }

}
