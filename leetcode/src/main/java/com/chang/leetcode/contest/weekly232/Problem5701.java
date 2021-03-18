package com.chang.leetcode.contest.weekly232;

public class Problem5701 {

    public boolean areAlmostEqual(String s1, String s2) {
        int diffs = 0;
        int a = -1, b = -1, c = -1, d = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (0 == diffs) {
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                } else if (1 == diffs) {
                    c = s1.charAt(i);
                    d = s2.charAt(i);
                }
                diffs++;
            }

            if (diffs > 2) {
                return false;
            }
        }

        return 0 == diffs || (2 == diffs && a == d && b == c);
    }

}
