package com.chang.leetcode.contest.weekly201;

public class Problem5483 {

    public String makeGood(String s) {
        int cnt = 1;
        int diff = 'a' - 'A';
        while (cnt > 0) {
            cnt = 0;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length() - 1) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != diff) {
                    sb.append(s.charAt(i));
                    i++;
                } else {
                    i += 2;
                    cnt++;
                }
            }
            if (i < s.length()) {
                sb.append(s.charAt(s.length() - 1));
            }

            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Problem5483 problem = new Problem5483();
        System.out.println(problem.makeGood("lEeeetcode"));
    }

}
