/**
 * 462. Minimum Moves to Equal Array Elements II
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem462 {

    // wrong answer
    public int minMoves2Wrong(int[] nums) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int ave = (int) (sum / nums.length + 0.5);   //四舍五入
        int moves = 0;
        for (int n : nums) {
            moves += Math.abs(n - ave);
        }
        return moves;
    }

    public static void main(String[] args) {
        Problem462 problem = new Problem462();

        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(2 == problem.minMoves2(nums1));

        int[] nums2 = new int[]{1, 0, 0, 8, 6};
        System.out.println(14 == problem.minMoves2(nums2));
    }

    // 666
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }


}
