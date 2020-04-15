/**
 * 334. Increasing Triplet Subsequence
 * <p>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * <p>
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 * <p>
 * Example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 */
package com.chang.leetcode;

public class Problem334 {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem334 problem = new Problem334();
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(problem.increasingTriplet(nums1));
        int[] nums2 = new int[]{5, 4, 3, 2, 1};
        System.out.println(!problem.increasingTriplet(nums2));
    }
}
