/*
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of
 * the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (null == s || s.length() == 0) {
            return res;
        }
        partitionDiv(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void partitionDiv(String s, int start, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String sTmp = s.substring(start, i);
            if (isPalindrome(sTmp)) {
                list.add(sTmp);
                partitionDiv(s, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String sTmp) {
        int start = 0;
        int end = sTmp.length() - 1;
        while (start < end && sTmp.charAt(start) == sTmp.charAt(end)) {
            start++;
            end--;
        }
        return start >= end ? true : false;
    }

    public static void main(String[] args) {
        Problem131 problem = new Problem131();
        List<List<String>> res = problem.partition("aab");
        System.out.println(ArrayToStringUtil.twoDimension(res));
    }
}



