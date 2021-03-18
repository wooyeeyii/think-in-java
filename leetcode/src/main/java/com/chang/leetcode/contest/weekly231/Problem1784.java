package com.chang.leetcode.contest.weekly231;

public class Problem1784 {

    public boolean checkOnesSegment(String s) {
        char last = '0';
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != last) {
                cnt++;
                last = s.charAt(i);
            }

            if (cnt > 2) {
                return false;
            }
        }

        return true;
    }

}
