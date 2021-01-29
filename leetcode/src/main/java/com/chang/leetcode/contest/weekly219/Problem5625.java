package com.chang.leetcode.contest.weekly219;

public class Problem5625 {

    public int numberOfMatches(int n) {
        int rounds = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                rounds += n;
            } else {
                n = (n - 1) / 2 + 1;
                rounds += n - 1;
            }
        }

        return rounds;
    }

}
