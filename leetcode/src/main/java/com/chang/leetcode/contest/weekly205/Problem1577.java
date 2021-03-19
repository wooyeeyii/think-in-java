/*
 * 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 *
 * Given two arrays of integers nums1 and nums2, return the number of triplets formed (type 1 and type 2) under the following rules:
 * Type 1: Triplet (i, j, k) if nums1[i]2 == nums2[j] * nums2[k] where 0 <= i < nums1.length and 0 <= j < k < nums2.length.
 * Type 2: Triplet (i, j, k) if nums2[i]2 == nums1[j] * nums1[k] where 0 <= i < nums2.length and 0 <= j < k < nums1.length.
 *
 *
 * Example 1:
 * Input: nums1 = [7,4], nums2 = [5,2,8,9]
 * Output: 1
 * Explanation: Type 1: (1,1,2), nums1[1]^2 = nums2[1] * nums2[2]. (4^2 = 2 * 8).
 *
 * Example 2:
 * Input: nums1 = [1,1], nums2 = [1,1,1]
 * Output: 9
 * Explanation: All Triplets are valid, because 1^2 = 1 * 1.
 * Type 1: (0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2).  nums1[i]^2 = nums2[j] * nums2[k].
 * Type 2: (0,0,1), (1,0,1), (2,0,1). nums2[i]^2 = nums1[j] * nums1[k].
 *
 * Example 3:
 * Input: nums1 = [7,7,8,3], nums2 = [1,2,9,7]
 * Output: 2
 * Explanation: There are 2 valid triplets.
 * Type 1: (3,0,2).  nums1[3]^2 = nums2[0] * nums2[2].
 * Type 2: (3,0,1).  nums2[3]^2 = nums1[0] * nums1[1].
 *
 * Example 4
 * Input: nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
 * Output: 0
 * Explanation: There are no valid triplets.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 1 <= nums1[i], nums2[i] <= 10^5
 */
package com.chang.leetcode.contest.weekly205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1577 {

    public int numTriplets(int[] nums1, int[] nums2) {
        long count = 0;
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        for (long n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0L) + 1);
        }
        for (long n : nums2) {
            map2.put(n, map2.getOrDefault(n, 0L) + 1);
        }

        count += count(map1, map2);
        count += count(map2, map1);
        return (int) count;
    }

    private long count(Map<Long, Long> map1, Map<Long, Long> map2) {
        long count = 0;
        for (long n : map1.keySet()) {
            Set<Long> used = new HashSet<>();
            long mul = n * n;
            for (long m : map2.keySet()) {
                if (used.contains(m)) {
                    continue;
                }

                used.add(m);
                if (0 == mul % m) {
                    long r = (long) (mul / m);
                    used.add(r);
                    if (map2.containsKey(r)) {
                        count += calCount(map1.get(n), m, map2.get(m), r, map2.get(r));
                    }
                }
            }
        }

        return count;
    }

    private long calCount(Long mulCnt, long m, Long mCnt, long r, Long rCnt) {
        if (m == r) {
            if (mCnt == 1) {
                return 0;
            }
            return mCnt * (mCnt - 1) / 2 * mulCnt;
        }

        return mCnt * rCnt * mulCnt;
    }

    public static void main(String[] args) {
        Problem1577 problem = new Problem1577();
        System.out.println(problem.numTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        System.out.println(problem.numTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
        System.out.println(problem.numTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
        System.out.println(problem.numTriplets(new int[]{4, 7, 9, 11, 23}, new int[]{3, 5, 1024, 12, 18}));
        System.out.println(problem.numTriplets(new int[]{100000, 100000, 100000}, new int[]{100000, 100000, 100000}));
    }

    public int numTripletsExample(int[] nums1, int[] nums2) {
        Map<Long, Long> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            for (int j = i + 1; j < nums1.length; j++) {
                long prod = (long) nums1[i] * nums1[j];
                map1.put(prod, map1.getOrDefault(prod, 0l) + 1);
            }

        Map<Long, Long> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            for (int j = i + 1; j < nums2.length; j++) {
                long prod = (long) nums2[i] * nums2[j];
                map2.put(prod, map2.getOrDefault(prod, 0l) + 1);
            }

        long res = 0l;
        for (long n : nums1) res += map2.getOrDefault((long) n * n, 0l);
        for (long n : nums2) res += map1.getOrDefault((long) n * n, 0l);

        return (int) res;
    }


}
