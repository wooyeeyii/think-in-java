package com.chang.leetcode.contest.weekly204;

public class Problem5500 {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int start = 0;
        int end = start;
        while (end < nums.length) {
            if (0 == nums[end]) {
                max = Math.max(max, findMax(nums, start, end));
                start = end + 1;
                end = start;
            } else {
                end++;
            }
        }

        max = Math.max(max, findMax(nums, start, end));

        return max;
    }

    private int findMax(int[] nums, int start, int end) {
        int cnt = 0;
        int first = -1, last = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                cnt++;
                if (-1 == first) {
                    first = i;
                    last = i;
                } else {
                    last = i;
                }
            }
        }

        if (cnt % 2 == 0) {
            return end - start;
        } else {
            return Math.max(end - first - 1, last - start);
        }
    }

    public static void main(String[] args) {
        Problem5500 problem = new Problem5500();
        System.out.println(problem.getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(problem.getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(problem.getMaxLen(new int[]{-1, -2, -3, 0, 1}));
        System.out.println(problem.getMaxLen(new int[]{-1, 2}));
        System.out.println(problem.getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
    }

    public int getMaxLenExample(int[] nums) {
        int firstEvenNeg = -1, firstOddNeg = -2, res = 0, negCount = 0;  // treat 0 neg as even
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // reset every time you met a zero;
                negCount = 0; // neg count after last zero
                firstEvenNeg = i;
                firstOddNeg = -2;
            } else {
                if (nums[i] < 0) negCount++;  // number of negatives from last zero or head of array
                if (negCount == 1 && firstOddNeg == -2) firstOddNeg = i;   // init odd cnt neg;
                if (negCount % 2 == 0) res = Math.max(res, i - firstEvenNeg);
                else if (firstOddNeg > -2) res = Math.max(res, i - firstOddNeg);
            }
        }
        return res;
    }

}
