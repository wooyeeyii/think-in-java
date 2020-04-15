/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
package com.chang.leetcode.array;

public class Problem31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = length - 1;
        boolean flag = false;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                flag = true;
                index = i;
                break;
            }
        }
        if (flag) {
            int start = index;
            while (index + 1 < length && nums[start - 1] < nums[index + 1]) {
                index++;
            }
            swap(nums, start - 1, index);
            reverse(nums, start, length - 1);
        } else {
            reverse(nums, 0, length - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void reverse(int[] nums, int m, int n) {
        while (m < n) {
            swap(nums, m, n);
            m++;
            n--;
        }
    }

}
