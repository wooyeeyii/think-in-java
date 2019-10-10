package com.chang.leetcode.contest.biweekly10;

import com.chang.leetcode.dp.Problem516;

public class Problem5099 {

    //  Time Limit Exceeded
    public boolean isValidPalindromeTooSlow(String s, int k) {
        int len = s.length();
        if(k >= len - 1) {
            return true;
        }

        for(int i = 0; i < len; i++) {
            int count = 0;
            for(int j = len - 1 - count; j > i && (i + count) <= k; j--, count++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(isValidPalindromeTooSlow(s.substring(i + 1, j), k - i - count)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isValidPalindrome(String s, int k) {
        Problem516 problem516 = new Problem516();
        return k >= (s.length() - problem516.longestPalindromeSubseq(s));
    }

    public static void main(String[] args) {
        Problem5099 problem = new Problem5099();
        System.out.println(problem.isValidPalindrome("abcdeca", 2));
        System.out.println(problem.isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216));
    }
}
