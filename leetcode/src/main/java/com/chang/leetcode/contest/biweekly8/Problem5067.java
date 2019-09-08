package com.chang.leetcode.contest.biweekly8;

public class Problem5067 {

    public int countLetters(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem5067 problem = new Problem5067();
        System.out.println(8 == problem.countLetters("aaaba"));
    }
}
