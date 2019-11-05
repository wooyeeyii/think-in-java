/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * <p>
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * <p>
 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * <p>
 * Example 3:
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
package com.chang.leetcode.contest.weekly160;

import java.util.List;

public class Problem1239OfExample2 implements Interface1239 {

    private int maxLen = 0;

    public int uniqueCharsToInt(String str) {
        int b = 0;
        if (str == null) return b;

        for (int i = 0; i < str.length(); i++) {
            if ((b & 1 << str.charAt(i) - 'a') == 0) {
                b |= 1 << str.charAt(i) - 'a';
            } else {
                return 0;
            }
        }
        return b;
    }

    @Override
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return maxLen;

        int[] bitmapArr = new int[arr.size()];
        boolean uniqueAny = false;
        for (int i = 0; i < arr.size(); i++) {
            int b = uniqueCharsToInt(arr.get(i));
            if (b == 0) continue;
            bitmapArr[i] = b;
            uniqueAny = true;
        }

        if (uniqueAny == true) {
            dfs(bitmapArr, 0, 0);
        }

        return maxLen;
    }

    public void dfs(int[] bitmapArr, int index, int concat) {

        maxLen = Math.max(maxLen, Integer.bitCount(concat));

        if (bitmapArr == null || bitmapArr.length - 1 < index) return;

        for (int i = index; i < bitmapArr.length; i++) {
            if ((bitmapArr[i] & concat) == 0) {
                int newConcat = bitmapArr[i] | concat;
                dfs(bitmapArr, i + 1, newConcat);
            }
        }
    }

}


