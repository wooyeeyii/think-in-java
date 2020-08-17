package com.chang.leetcode.contest.weekly202;

public class Problem5185 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int n : arr) {
            if (1 == n % 2) {
                cnt++;
                if (cnt >= 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }

        return false;
    }

}
