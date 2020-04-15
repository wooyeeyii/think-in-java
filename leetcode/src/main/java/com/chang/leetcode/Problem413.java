/**
 * 413. Arithmetic Slices
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and
 * if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * <p>
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given.
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * Example:
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (null == A || 3 > A.length) {
            return 0;
        }
        int number = 0;
        List<Integer> list = new ArrayList<>();
        int diff = A[1] - A[0];
        int pos = 2;
        int count = 2;
        while (pos < A.length) {
            if (A[pos] - A[pos - 1] == diff) {
                count++;
            } else {
                if (count >= 3) {
                    list.add(count);
                }
                diff = A[pos] - A[pos - 1];
                count = 2;
            }
            pos++;
        }

        if (count >= 3) list.add(count);
        for (int n : list) {
            number += cal(n);
        }
        return number;
    }

    private int cal(int n) {
        return (n - 2) * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Problem413 problem = new Problem413();
        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(3 == problem.numberOfArithmeticSlices(nums1));
        int[] nums2 = new int[]{1, 2, 3, 8, 9, 10};
        System.out.println(2 == problem.numberOfArithmeticSlices(nums2));
    }

}
