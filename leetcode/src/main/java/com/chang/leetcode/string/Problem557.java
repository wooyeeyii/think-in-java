/**
 * 557. Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
package com.chang.leetcode.string;

public class Problem557 {

    public String reverseWords(String s) {
        if(null == s || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int idx = 0;
        int start = idx;
        int end = idx;
        while(idx < len) {
            if(s.charAt(idx) == ' ') {
                for(int i = end - 1; i >= start; i--) {
                    sb.append(s.charAt(i));
                }
                sb.append(" ");
                start = idx + 1;
                end = start;
            } else {
                end++;
            }
            idx++;
        }

        for(int i = end - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String reverseWordsUseSplit(String s) {
        if(null == s || s.length() == 0) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String si : strs) {
            sb.append(reverse(si)).append(" ");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    private String reverse(String si) {
        StringBuilder sb = new StringBuilder();
        for(int i = si.length() - 1; i >= 0; i--) {
            sb.append(si.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem557 problem = new Problem557();
        System.out.println("s'teL ekat edoCteeL tsetnoc".equals(problem.reverseWordsUseSplit("Let's take LeetCode contest")));
    }

}
