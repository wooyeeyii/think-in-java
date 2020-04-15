/**
 * Peak Index in a Mountain Array
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [0,2,1,0]
 * Output: 1
 */
package com.chang.leetcode;

public class Problem852 {

    public int peakIndexInMountainArray2(int[] A) {
        int i = 0;
        for (; i < A.length - 1; i++) {
            if (A[i + 1] < A[i]) {
                break;
            }
        }
        return i;
    }

    //二分搜索
    public int peakIndexInMountainArray(int[] A) {
        int begin = 0, end = A.length - 1, middle = (begin + end) / 2;
        while (begin < middle) {
            if (A[middle] > A[middle - 1] && A[middle] > A[middle + 1]) {
                break;
            } else if (A[middle] > A[middle - 1] && A[middle] < A[middle + 1]) {
                begin = middle;
            } else {
                end = middle;
            }
            middle = (begin + end) / 2;
        }
        return middle;
    }

    public static void main(String[] args) {
        Problem852 problem = new Problem852();
        int[] nums1 = new int[]{0, 1, 0};
        System.out.println(1 == problem.peakIndexInMountainArray(nums1));
        int[] nums2 = new int[]{0, 2, 1, 0};
        System.out.println(1 == problem.peakIndexInMountainArray(nums2));
        int[] nums3 = new int[]{3, 4, 5, 1};
        System.out.println(2 == problem.peakIndexInMountainArray(nums3));
    }
}
