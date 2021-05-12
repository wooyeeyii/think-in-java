package com.chang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem5725 {

    // TODO
    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                continue;
            }

            Set<Integer> nextSet = new HashSet<>();
            nextSet.add(n);
            set.forEach(m -> {
                nextSet.add(m);
                nextSet.add(gcd(m, n));
            });
            set = nextSet;
        }
        return set.size();
    }

    private int gcd(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
