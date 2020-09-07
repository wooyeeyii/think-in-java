package com.chang.leetcode.contest.weekly203;

import java.util.Arrays;

public class Problem5496 {

    public int maxCoins(int[] piles) {
        int len = piles.length;
        Arrays.sort(piles);
        int idx = len - 2;
        int sum = 0;
        for (int i = 0; i < len / 3; i++) {
            sum += piles[idx];
            idx -= 2;
        }

        return sum;
    }

}
