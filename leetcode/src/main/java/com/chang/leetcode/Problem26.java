package com.chang.leetcode;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int i = 0;
        int corPos = 0;
        int corCount = 0;
        for (i = 0; i < nums.length; i++) {
            int value = nums[i];
            nums[corPos++] = nums[i];
            corCount++;
            while (i + 1 < nums.length && nums[i + 1] == value) {
                i++;
            }
        }

        return corCount;
    }

    public static void main(String[] args) {
        Problem26 problem = new Problem26();
        int[] nums = new int[]{1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4};
        System.out.println(problem.removeDuplicates(nums));
        System.out.println(nums);
    }
}
