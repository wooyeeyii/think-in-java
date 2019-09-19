/**
 * 1186. Maximum Subarray Sum with One Deletion
 *
 * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion.
 * In other words, you want to choose a subarray and optionally delete one element from it so that
 * there is still at least one element left and the sum of the remaining elements is maximum possible.
 *
 * Note that the subarray needs to be non-empty after deleting one element.
 *
 * Example 1:
 * Input: arr = [1,-2,0,3]
 * Output: 4
 * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 *
 * Example 2:
 * Input: arr = [1,-2,-2,3]
 * Output: 3
 * Explanation: We just choose [3] and it's the maximum sum.
 *
 * Example 3:
 * Input: arr = [-1,-1,-1,-1]
 * Output: -1
 * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it,
 * then get an empty subarray to make the sum equals to 0.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
package com.chang.leetcode.contest.weekly153;

import java.util.ArrayList;
import java.util.List;

public class Problem1186 {

    /*public int maximumSum(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                list.add(sum);
                sum = 0;
                list.add(arr[i]);
            } else {
                sum += arr[i];
            }
        }
        if (arr[arr.length - 1] >= 0) {
            list.add(sum);
        }

        return 0;
    }*/

    public static void main(String[] args) {
        Problem1186 problem = new Problem1186();
        System.out.println(4 == problem.maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(3 == problem.maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(-1 == problem.maximumSum(new int[]{-1, -1, -1, -1}));
        System.out.println(10 == problem.maximumSum(new int[]{1, 2, 3, 4}));
    }

    // Compute maxEndHere and maxStartHere arrays and also find overall max along with them.
    // Now, evaluate the case where 1-element can be eliminated, that at each index, we can make use of maxEndHere[i-1] + maxStartHere[i+1]
    public int maximumSum(int[] a) {
        int n = a.length;
        int[] maxEndHere = new int[n], maxStartHere = new int[n];
        int max = a[0];
        maxEndHere[0] = a[0];
        for (int i = 1; i < n; i++) {
            maxEndHere[i] = Math.max(a[i], maxEndHere[i - 1] + a[i]);
            max = Math.max(max, maxEndHere[i]); // here, 包含不删除元素能获得的最大的值
        }
        maxStartHere[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            maxStartHere[i] = Math.max(a[i], maxStartHere[i + 1] + a[i]);

        for (int i = 1; i < n - 1; i++)
            max = Math.max(max, maxEndHere[i - 1] + maxStartHere[i + 1]);
        return max;
    }

}
