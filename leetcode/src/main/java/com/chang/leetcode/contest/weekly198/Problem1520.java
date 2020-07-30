/**
 * 1520. Maximum Number of Non-Overlapping Substrings
 *
 * Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:
 * The substrings do not overlap, that is for any two substrings s[i..j] and s[k..l], either j < k or i > l is true.
 * A substring that contains a certain character c must also contain all occurrences of c.
 * Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings,
 * return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.
 *
 * Notice that you can return the substrings in any order.
 *
 * Example 1:
 * Input: s = "adefaddaccc"
 * Output: ["e","f","ccc"]
 * Explanation: The following are all the possible substrings that meet the conditions:
 * [
 *   "adefaddaccc"
 *   "adefadda",
 *   "ef",
 *   "e",
 *   "f",
 *   "ccc",
 * ]
 * If we choose the first string, we cannot choose anything else and we'd get only 1. If we choose "adefadda",
 * we are left with "ccc" which is the only one that doesn't overlap, thus obtaining 2 substrings. Notice also,
 * that it's not optimal to choose "ef" since it can be split into two. Therefore, the optimal way is to choose ["e","f","ccc"] which gives us 3 substrings.
 * No other solution of the same number of substrings exist.
 *
 * Example 2:
 * Input: s = "abbaccd"
 * Output: ["d","bb","cc"]
 * Explanation: Notice that while the set of substrings ["d","abba","cc"] also has length 3, it's considered incorrect since it has larger total length.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s contains only lowercase English letters.
 */
package com.chang.leetcode.contest.weekly198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1520 {

    int checkSubstr(String s, int i, int l[], int r[]) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; ++j) {
            if (l[s.charAt(j) - 'a'] < i)
                return -1;
            right = Math.max(right, r[s.charAt(j) - 'a']);
        }
        return right;
    }

    public List<String> maxNumOfSubstrings(String s) {
        int l[] = new int[26], r[] = new int[26];
        Arrays.fill(l, s.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            int ch = s.charAt(i) - 'a';
            l[ch] = Math.min(l[ch], i);
            r[ch] = Math.max(r[ch], i);
        }
        int right = s.length();
        for (int i = 0; i < s.length(); ++i)
            if (i == l[s.charAt(i) - 'a']) {
                int new_right = checkSubstr(s, i, l, r);
                if (new_right != -1) {
                    if (i > right || res.isEmpty())
                        res.add("");
                    right = new_right;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        return res;
    }

}
