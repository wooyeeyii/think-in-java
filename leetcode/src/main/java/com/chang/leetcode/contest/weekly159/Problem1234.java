/*
 * 1234. Replace the Substring for Balanced String
 *
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.
 *
 * A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.
 *
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.
 *
 * Return 0 if the string is already balanced.
 *
 * Example 1:
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 *
 * Example 2:
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 *
 * Example 3:
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 *
 * Example 4:
 * Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s.length is a multiple of 4
 * s contains only 'Q', 'W', 'E' and 'R'.
 */
package com.chang.leetcode.contest.weekly159;

import java.util.HashMap;
import java.util.Map;

public class Problem1234 {

    public int balancedStringSlow(String s) {
        int len = s.length();
        int same = len / 4;
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        int left = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            Character c = s.charAt(i);
            int m = map.get(c);
            if (m + 1 > same) {
                break;
            }
            map.put(c, m + 1);
        }
        if (i == len) return 0;
        left = i;

        int max = left;
        int right = len - 1;
        while (left >= 0) {
            while (right > left) {
                Character c2 = s.charAt(right);
                if (map.get(c2) == same) {
                    break;
                } else {
                    map.put(c2, map.get(c2) + 1);
                    right--;
                }
            }
            max = Math.max(max, left - 1 + len - right);

            if (left <= 0) break;
            Character c1 = s.charAt(left - 1);
            map.put(c1, map.get(c1) - 1);
            left--;
        }
        return len - max;
    }

    public static void main(String[] args) {
        Problem1234 problem = new Problem1234();
        System.out.println(0 == problem.balancedString("QWER"));
        System.out.println(1 == problem.balancedString("QQWE"));
        System.out.println(2 == problem.balancedString("QQQW"));
        System.out.println(3 == problem.balancedString("QQQQ"));
        System.out.println(5 == problem.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
    }

    /*
     * Intuition
     * We want a minimum length of substring,
     * which leads us to the solution of sliding window.
     * Specilly this time we don't care the count od elements inside the window,
     * we want to know the count outside the window.
     *
     * Explanation
     * One pass the all frequency of "QWER".
     * Then slide the windon in the string s.
     *
     * Imagine that we erase all character inside the window,
     * as we can modyfy it whatever we want,
     * and it will always increase the count outside the window.
     *
     * So we can make the whole string balanced,
     * as long as max(count[Q],count[W],count[E],count[R]) <= n / 4.
     *
     * Complexity:
     * Time O(N), one pass for counting, one pass for sliding window
     * Space O(1)
     */
    public int balancedString(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int n = s.length();
        int res = n;
        int i = 0;
        for (int j = 0; j < n; j++) {
            count[s.charAt(j)]--;
            while (i < n
                    && count['Q'] <= n / 4
                    && count['W'] <= n / 4
                    && count['E'] <= n / 4
                    && count['R'] <= n / 4) {
                res = Math.min(res, j - i + 1);
                count[s.charAt(i++)]++;
            }
        }
        return res;
    }

}
