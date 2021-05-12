package com.chang.leetcode;

public class Problem5722 {

    public String truncateSentence(String s, int k) {
        int idx = 0;
        int cnt = 0;
        while (idx < s.length() && cnt < k) {
            if (' ' == s.charAt(idx)) {
                cnt++;
            }
            idx++;
        }
        return s.length() == idx ? s : s.substring(0, idx - 1);
    }

}
