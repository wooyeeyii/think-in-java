package com.chang.leetcode.contest.weekly156;

import java.util.Arrays;

public class Problem5216 {

    public int countVowelPermutation(int n) {
        int HUGE = (int) Math.pow(10, 9) + 7;
        int[][] flag = new int[5][5];
        flag[0] = new int[]{0, 1, 1, 0, 1};
        flag[1] = new int[]{1, 0, 1, 0, 0};
        flag[2] = new int[]{0, 1, 0, 1, 0};
        flag[3] = new int[]{0, 0, 1, 0, 0};
        flag[4] = new int[]{0, 0, 1, 1, 0};

        int[] before = new int[5];
        Arrays.fill(before, 1);
        for (int i = 2; i <= n; i++) {
            int[] cur = new int[5];
            for (int j = 0; j < 5; j++) {
                int count = 0;
                for (int m = 0; m < 5; m++) {
                    count = (count + (before[m] * flag[j][m]) % HUGE) % HUGE;
                }
                cur[j] = count;
            }
            before = cur;
        }

        int sum = 0;
        for (int m : before) {
            sum = (sum + (m % HUGE)) % HUGE;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem5216 problem = new Problem5216();
        System.out.println(5 == problem.countVowelPermutation(1));
        System.out.println(10 == problem.countVowelPermutation(2));
        System.out.println(68 == problem.countVowelPermutation(5));
    }


}
