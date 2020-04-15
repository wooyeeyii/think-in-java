/**
 * 1208. Get Equal Substrings Within Budget
 * <p>
 * You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character
 * of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 * You are also given an integer maxCost.
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 * <p>
 * Example 1:
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
 * <p>
 * Example 2:
 * Input: s = "abcd", t = "cdef", maxCost = 3
 * Output: 1
 * Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
 * <p>
 * Example 3:
 * Input: s = "abcd", t = "acde", maxCost = 0
 * Output: 1
 * Explanation: You can't make any change, so the maximum length is 1.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s and t only contain lower case English letters.
 */
package com.chang.leetcode.contest.weekly156;

public class Problem1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int right = 0;
        int sum = diff[0];
        int max = 0;
        while (right < len && left < len) {
            if (sum > maxCost) {
                sum -= diff[left];
                left++;
            } else {
                right++;
                max = Math.max(max, right - left);
                if (right < len) {
                    sum += diff[right];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem1208 problem = new Problem1208();
        System.out.println(3 == problem.equalSubstring("abcd", "bcdf", 3));
        System.out.println(1 == problem.equalSubstring("abcd", "cdef", 3));
        System.out.println(1 == problem.equalSubstring("abcd", "acde", 0));
        System.out.println(0 == problem.equalSubstring("abcd", "bcde", 0));
        System.out.println(2 == problem.equalSubstring("krrgw", "zjxss", 19));
        System.out.println(3 == problem.equalSubstring("zabc", "fbcd", 4));
        System.out.println(5 == problem.equalSubstring("ujteygggjwxnfl", "nstsenrzttikoy", 43));
    }
}
