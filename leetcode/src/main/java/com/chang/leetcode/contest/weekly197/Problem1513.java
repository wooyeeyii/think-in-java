/**
 * 1513. Number of Substrings With Only 1s
 *
 * Given a binary string s (a string consisting only of '0' and '1's).
 * Return the number of substrings with all characters 1's.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: s = "0110111"
 * Output: 9
 * Explanation: There are 9 substring in total with only 1's characters.
 * "1" -> 5 times.
 * "11" -> 3 times.
 * "111" -> 1 time.
 *
 * Example 2:
 * Input: s = "101"
 * Output: 2
 * Explanation: Substring "1" is shown 2 times in s.
 *
 * Example 3:
 * Input: s = "111111"
 * Output: 21
 * Explanation: Each substring contains only 1's characters.
 *
 * Example 4:
 * Input: s = "000"
 * Output: 0
 *
 * Constraints:
 * s[i] == '0' or s[i] == '1'
 * 1 <= s.length <= 10^5
 */
package com.chang.leetcode.contest.weekly197;

import java.util.ArrayList;
import java.util.List;

public class Problem1513 {

    private static final int C = (int) Math.pow(10, 9) + 7;

    public int numSub(String s) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int count = 0;
        int max = 0;
        while (idx < s.length()) {
            if ('1' == s.charAt(idx)) {
                count++;
            } else {
                if (count > 0) {
                    max = Math.max(max, count);
                    list.add(count);
                }
                count = 0;
            }
            idx++;
        }

        if (count > 0) {
            list.add(count);
        }

        Long res = list.stream()
                .map(n -> {
                    long a = (1 + n);
                    long b = n;
                    return a * b / 2 % C;
                })
                .reduce(0L, (a, b) -> (a + b) % C);
        return res.intValue();
    }

    public static void main(String[] args) {
        Problem1513 problem = new Problem1513();
        System.out.println(problem.numSub("0110111"));
        System.out.println(problem.numSub("101"));
        System.out.println(problem.numSub("111111"));
        System.out.println(problem.numSub("000"));
        System.out.println(problem.numSub("1111111111011010011"));
    }

    public int numSub2(String s) {
        int res = 0, count = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == '1' ? count + 1 : 0;
            res = (res + count) % mod;
        }
        return res;
    }

}
