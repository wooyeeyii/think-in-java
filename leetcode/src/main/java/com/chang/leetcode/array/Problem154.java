/**
 * 154. Find Minimum in Rotated Sorted Array II
 * <p>
 * same problem in 153, but there may be duplicate number in array.
 * <p>
 * Example 1:
 * Input: [1,3,5]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [2,2,2,0,1]
 * Output: 0
 */
package com.chang.leetcode.array;

public class Problem154 {
    public int findMin(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return -1;
        }

        if (null == nums || nums.length <= 0) {
            return -1;
        }

        int startPos = 0;
        int endPos = nums.length - 1;
        int midPos = (startPos + endPos) / 2;
        while (startPos < midPos && midPos < endPos) {
            if (nums[midPos] == nums[endPos] && nums[midPos] == nums[startPos]) {
                // 遍历其中一半数据，若全相等，则对另一半做处理
                int i = startPos + 1;
                while (i < midPos && nums[i] == nums[startPos]) {
                    i++;
                }
                if (i < midPos) {
                    startPos = i;
                    endPos = midPos;
                } else {
                    startPos = midPos + 1;
                }
            } else if (nums[midPos] <= nums[endPos]) {
                // 最小值在前半段
                endPos = midPos;
            } else {
                // 最小值在后半段
                startPos = midPos;
            }
            midPos = (startPos + endPos) / 2;
        }

        return nums[startPos] > nums[endPos] ? nums[endPos] : nums[startPos];
    }

    public int findMinSample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, n = nums.length, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) {
                --right;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Problem154 problem = new Problem154();
        int[] array1 = new int[]{3, 4, 5, 1, 2};
        int[] array2 = new int[]{2, 2, 2, 0, 1};
        int[] array3 = new int[]{2, 2, 2, 2, 2, 2};
        int[] array4 = new int[]{2};
        int[] array5 = new int[]{3, 3, 1, 3};
        int[] array6 = new int[]{1, 3,  3};
        System.out.println(problem.findMin(array1));
        System.out.println(problem.findMin(array2));
        System.out.println(problem.findMin(array3));
        System.out.println(problem.findMin(array4));
        System.out.println(problem.findMin(array5));
        System.out.println(problem.findMin(array6));
    }
}
