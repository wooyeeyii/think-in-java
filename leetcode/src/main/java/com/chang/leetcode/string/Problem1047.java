package com.chang.leetcode.string;

public class Problem1047 {

    public String removeDuplicates(String s) {
        int idx = 0, len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++, idx++) {
            chars[idx] = chars[i];
            if (idx > 0 && chars[idx - 1] == chars[idx]) {
                idx -= 2;
            }
        }
        return new String(chars, 0, idx);
    }

}
