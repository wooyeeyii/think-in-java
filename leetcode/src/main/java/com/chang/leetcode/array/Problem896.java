/*
 * 896. Monotonic Array
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 *
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 *
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 *
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 *
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 *
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
package com.chang.leetcode.array;

public class Problem896 {

    // too complex
    public boolean isMonotonicSelf(int[] A) {
        if (null == A || A.length <= 2) {
            return true;
        }

        int len = A.length;
        int i = 0;
        while (i < len - 1 && A[i] == A[i + 1]) {
            i++;
        }

        if (i >= len - 2) {
            return true;
        }

        if (A[i] > A[i + 1]) {
            for (int j = i + 1; j < len - 1; j++) {
                if (A[j] < A[j + 1]) {
                    return false;
                }
            }
        } else {
            for (int j = i + 1; j < len - 1; j++) {
                if (A[j] > A[j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem896 problem = new Problem896();
        System.out.println(problem.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(problem.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(problem.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(problem.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(problem.isMonotonic(new int[]{1, 1, 1}));
        System.out.println(problem.isMonotonic(new int[]{1, 1, 1, 2}));
    }

    public boolean isMonotonic(int[] A) {
        boolean dec = true, inc = true;
        for (int i = 0; i < A.length - 1; i++) {
            dec &= A[i] >= A[i + 1];
            inc &= A[i] <= A[i + 1];
        }
        return dec || inc;
    }

}
