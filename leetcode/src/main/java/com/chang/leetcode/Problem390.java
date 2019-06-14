/**
 * 390. Elimination Game
 *
 *  There is a list of sorted integers from 1 to n. Starting from left to right,
 *  remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and
 * every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, u
 * ntil a single number remains.
 * Find the last number that remains starting with a list of length n.
 *
 * Example:
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 */
package com.chang.leetcode;

public class Problem390 {

    public int lastRemaining(int n) {
        boolean left = true;
        int remain = n;
        int head = 1;
        int step = 1;
        while(remain > 1) {
            if(left || 1 == remain % 2) {
                head = head + step;
            }
            remain /= 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem390 problem = new Problem390();
        System.out.println(6 == problem.lastRemaining(9));
    }
}
