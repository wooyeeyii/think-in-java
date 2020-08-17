package com.chang.leetcode.contest.weekly201;

public class Problem5484 {

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (int i = 2; i <= n; i++) {
            String s = sb.toString();
            sb.append('1');
            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append('0' == s.charAt(j) ? '1' : '0');
            }

            if (sb.length() > k - 1) {
                return sb.charAt(k - 1);
            }
        }

        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        Problem5484 problem = new Problem5484();
        System.out.println(problem.findKthBit(3, 1));
        System.out.println(problem.findKthBit(4, 11));
    }

}
