/*
 * 1005. Maximize Sum Of Array After K Negations
 *
 * Given an array A of integers, we must modify the array in the following way:
 * we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
 * (We may choose the same index i multiple times.)
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 * Example 1:
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 *
 * Example 2:
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 *
 * Example 3:
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 *
 * Note:
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
package com.chang.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1005 {

    // sort is slow, find another way.
    public int largestSumAfterKNegationsSlow(int[] A, int k) {
        Arrays.sort(A);
        for (int i = 0; k > 0 && i < A.length && A[i] < 0; i++, k--) {
            A[i] = -A[i];
        }

        int min = Integer.MAX_VALUE, sum = 0;
        for (int n : A) {
            sum += n;
            min = Math.min(min, n);
        }
        return sum - (k % 2) * min * 2;
    }

    public int largestSumAfterKNegations(int[] A, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : A) {
            queue.offer(n);
        }

        // always flip the smallest number
        while (k-- > 0) {
            queue.offer(-queue.poll());
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += queue.poll();
        }
        return sum;
    }

}
