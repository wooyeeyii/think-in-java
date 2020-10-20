/**
 *  1593. Split a String Into the Max Number of Unique Substrings
 *
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string.
 * However, you must split the substrings such that all of them are unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc']
 * is not valid as you have 'a' and 'b' multiple times.
 *
 * Example 2:
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 *
 * Example 3:
 * Input: s = "aa"
 * Output: 1
 * Explanation: It is impossible to split the string any further.
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lower case English letters.
 */
package com.chang.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Problem1593 {

    public int maxUniqueSplit(String s) {
        return helper(s, new HashSet());
    }

    private int helper(String s, Set<String> set) {
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            String candidate = s.substring(0, i);
            if (!set.contains(candidate)) {
                set.add(candidate);
                max = Math.max(max, 1 + helper(s.substring(i), set));
                set.remove(candidate); // backtrack and try other splits
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem1593 problem = new Problem1593();
        System.out.println(problem.maxUniqueSplit("ababccc"));
        System.out.println(problem.maxUniqueSplit("aba"));
        System.out.println(problem.maxUniqueSplit("aa"));
        System.out.println(problem.maxUniqueSplit("addbsd"));
    }

}
