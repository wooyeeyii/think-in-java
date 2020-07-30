package com.chang.leetcode;

public class Problem283 {

    public void moveZeroes(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return;
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesExample(int[] nums) {
        int zero = 0, l = 0, r = nums.length;
        while (l < r) {
            if (nums[l] != 0) {
                int tmp = nums[zero];
                nums[zero++] = nums[l];
                nums[l] = tmp;
            }
            l++;
        }
    }

}
