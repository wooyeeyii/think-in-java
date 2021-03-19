/*
 * 1531. String Compression II
 *
 * Run-length encoding is a string compression method that works by replacing consecutive identical characters
 * (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run).
 * For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3". Thus the compressed string becomes "a2bc3".
 * Notice that in this problem, we are not adding '1' after single characters.
 * Given a string s and an integer k. You need to delete at most k characters from s such that the run-length encoded version of s has minimum length.
 * Find the minimum length of the run-length encoded version of s after deleting at most k characters.
 *
 * Example 1:
 * Input: s = "aaabcccd", k = 2
 * Output: 4
 * Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6.
 * Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5,
 * for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d. Therefore,
 * the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.
 *
 * Example 2:
 * Input: s = "aabbaa", k = 2
 * Output: 2
 * Explanation: If we delete both 'b' characters, the resulting compressed string would be "a4" of length 2.
 *
 * Example 3:
 * Input: s = "aaaaaaaaaaa", k = 0
 * Output: 3
 * Explanation: Since k is zero, we cannot delete anything. The compressed string is "a11" of length 3.
 *
 * Constraints:
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s contains only lowercase English letters.
 */
package com.chang.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Problem1531 {

    Integer[][][] memo;

    public int getLengthOfOptimalCompression(String s, int k) {
        List<int[]> count = new ArrayList<>();
        char lc = ' ';
        int cn = 0;
        // build a list of consecutive chars count, aaabbcc -> {{a, 3}, {b, 2}, {c, 2}}
        for (char c : s.toCharArray()) {
            if (lc != c) {
                if (cn != 0) count.add(new int[]{lc - 'a', cn});
                cn = 1;
                lc = c;
            } else {
                cn++;
            }
        }
        count.add(new int[]{lc - 'a', cn});
        memo = new Integer[count.size() + 1][k + 1][s.length() + 1];
        return f(count, 0, 0, k);
    }

    // a is a number of additional consecutive chars to be added, for cases like `aabbaa` and we delete two `b`
    // i is the counter, we go through all `count` list elements until we reach the end
    // k is the remaining chars we can delete
    int f(List<int[]> count, int a, int i, int k) {
        if (i == count.size()) return 0; // we reached the end
        if (memo[i][k][a] != null) return memo[i][k][a]; // we hit the cache
        int[] curr = count.get(i);
        int c = curr[1] + a;

        int best = l(c) + f(count, 0, i + 1, k); // first just try to keep everything

        // we are interested in game-changes only, like a10 -> a9, when string gets shorter
        for (int q : new int[]{0, 1, 9}) {
            int toRemove = c - q; // how many chars to be removed to achieve q
            if (toRemove <= k && q < c)
                best = Math.min(best, f(count, 0, i + 1, k - toRemove) + l(q));
        }

        // now let's handle the case like `aabbaa` -> `aaaa`
        int res = k;
        // what we do is go through all the next consecutive chars and try to remove them entirely
        // in case we encounter the same character as we have now, we just pass the current count as `a` parameter
        // e.g. `aaabbaa` -> `{{a,3},{b,2},{a,2}}
        // we remove {b,2} and call f(count, 3, j, res),
        // where res will be (k-charsWeRemovedInBetween)
        // and 3 is the count of `a` on the beginning which is passed to sum up with the two `a` we have in the end
        // which results in (2+3)=5 consecutive `a` chars, what we have when we remove both `b`
        for (int j = i + 1; j < count.size() && res >= 0; j++) {
            int[] next = count.get(j);
            if (next[0] == curr[0]) {
                best = Math.min(best, f(count, c, j, res));
                // no need to try removing the same characters
                break;
            }
            res -= next[1];
        }
        memo[i][k][a] = best;
        return best;
    }

    // length of char + its count, where n is a count of that char
    // if n == 15, l(15) = 3 -> e.g. `a15`
    int l(int n) {
        if (n <= 1) return n;
        if (n < 10) return 2;
        if (n < 100) return 3;
        return 4;
    }
}
