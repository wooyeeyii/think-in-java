/*
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
package com.chang.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem378 {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < len; i++) {
            que.offer(new int[]{matrix[i][0], i, 0});
        }
        int[] first = null;
        for (int i = 0; i < k; i++) {
            first = que.poll();
            if (first[2] + 1 < len) {
                que.offer(new int[]{matrix[first[1]][first[2] + 1], first[1], first[2] + 1});
            }
        }
        return null == first ? 0 : first[0];
    }

    public static void main(String[] args) {
        Problem378 problem = new Problem378();

        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(13 == problem.kthSmallest(matrix1, 8));
    }

    public int kthSmallest_Binary(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1; //[lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int getLessEqual(int[][] matrix, int mid) {
        int count = 0, j = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > mid) j--;
            count += (j + 1);
        }
        return count;
    }

}
