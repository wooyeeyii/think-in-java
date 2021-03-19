/*
 * 1209. Remove All Adjacent Duplicates in String II
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left
 * and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */
package com.chang.leetcode.contest.weekly156;

public class Problem1209 {

    public String removeDuplicates(String s, int k) {
        if (null == s || 0 == s.length() || k <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (dp[i - 1] + 1 == k) {
                    for (int count = 0; count < k; count++) {
                        dp[i - count] = 0;
                    }
                    i -= k;
                    s = s.substring(0, i + 1) + s.substring(i + k + 1);

                    if (i < 0) {
                        dp[0] = 1;
                        i = 0;
                    }
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                if (dp[i - 1] == k) {
                    int before = i - k - 1;
                    while (before >= 0 && dp[before] == k) {
                        before = before - k;
                    }
                    if (before >= 0 && s.charAt(i) == s.charAt(before)) {
                        dp[i] = (dp[before] + 1) % k;
                    } else {
                        dp[i] = 1;
                    }
                } else {
                    dp[i] = 1;
                }
            }
        }

        return s;
    }


    public static void main(String[] args) {
        Problem1209 problem = new Problem1209();
        System.out.println("abcd".equals(problem.removeDuplicatesExample("abcd", 2)));
        System.out.println("aa".equals(problem.removeDuplicatesExample("deeedbbcccbdaa", 3)));
        System.out.println("ps".equals(problem.removeDuplicatesExample("pbbcggttciiippooaais", 2)));
    }

    public String removeDuplicatesExample(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = (i > 0 && stack[i - 1] == stack[j]) ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }

}
