/**
 * 1248. Count Number of Nice Subarrays
 *
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *
 * Example 2:
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 *
 * Example 3:
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
package com.chang.leetcode.contest.weekly161;

import java.util.HashMap;
import java.util.Map;

public class Problem1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                count++;
                map.put(count, i);
            }
        }

        int result = 0;
        for (int i = k - 1; i <= count; i++) {
            if (map.containsKey(i - k + 1)) {
                int end = i + 1 > count ? len : map.get(i + 1);
                int start = i - k == 0 ? -1 : map.get(i - k);
                result = result + (map.get(i - k + 1) - start) * (end - map.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1248 problem = new Problem1248();
        System.out.println(2 == problem.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(0 == problem.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(16 == problem.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

    public int numberOfSubarraysExample(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }


}
