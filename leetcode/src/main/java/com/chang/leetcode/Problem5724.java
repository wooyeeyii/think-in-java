package com.chang.leetcode;

public class Problem5724 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) Math.pow(10, 9) + 7;
        long sumDiff = 0;
        int idx = -1, maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            if (dif > maxDiff) {
                idx = i;
                maxDiff = dif;
            }
            sumDiff = (sumDiff + dif) % mod;
        }

        if (-1 == idx) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int dif = Math.abs(nums1[i] - nums2[idx]);
            if (dif < minDiff) {
                minDiff = dif;
            }
        }
        return (int) ((sumDiff - Math.abs(nums1[idx] - nums2[idx]) + minDiff) % mod);
    }

    public static void main(String[] args) {
        Problem5724 problem = new Problem5724();
        System.out.println(problem.minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[] {9,3,5,1,7,4}));
    }

}
