/*
 * 1814. Count Nice Pairs in an Array
 *
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x.
 * For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 *
 * Example 1:
 * Input: nums = [42,11,1,97]
 * Output: 2
 * Explanation: The two pairs are:
 *  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 *  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
 *
 * Example 2:
 * Input: nums = [13,10,35,24,76]
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 109
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem1814 {

    // num[i] - rev(num[i]) = num[j] - rev(num[j])
    public int countNicePairs(int[] nums) {
        int mod = (int) Math.pow(10, 9) + 7;
        long cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int diff = n - rev(n);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
            cnt = (cnt + map.get(diff) - 1) % mod;
        }

        return (int) cnt;
    }

    private int rev(int n) {
        int revNum = 0;
        while (n > 0) {
            revNum = revNum * 10 + (n % 10);
            n /= 10;
        }
        return revNum;
    }

}
