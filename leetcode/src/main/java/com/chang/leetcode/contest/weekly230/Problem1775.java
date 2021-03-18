package com.chang.leetcode.contest.weekly230;

import java.util.Arrays;

public class Problem1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) {
            return 0;
        }

        // sum(nums1) < sum(nums2)
        if (sum1 > sum2) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int moveCnt = 0;
        int diff = Math.abs(sum2 - sum1);
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = len2 - 1;
        while (idx1 < len1 || idx2 >= 0) {
            moveCnt++;
            if (idx1 == len1) {
                diff -= (nums2[idx2] - 1);
                idx2--;
            } else if (idx2 == -1) {
                diff -= (6 - nums1[idx1]);
                idx1++;
            } else {
                if (nums2[idx2] > 7 - nums1[idx1]) {
                    diff -= (nums2[idx2] - 1);
                    idx2--;
                } else {
                    diff -= (6 - nums1[idx1]);
                    idx1++;
                }
            }

            if (diff <= 0) {
                return moveCnt;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem1775 problem = new Problem1775();
        // 3
        System.out.println(problem.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        // -1
        System.out.println(problem.minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
        // 3
        System.out.println(problem.minOperations(new int[]{6, 6}, new int[]{1}));
        // 1
        System.out.println(problem.minOperations(new int[]{5, 2, 1, 5, 2, 2, 2, 2, 4, 3, 3, 5}, new int[]{1, 4, 5, 5, 6, 3, 1, 3, 3}));
    }

}
