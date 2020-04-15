/**
 * 373. Find K Pairs with Smallest Sums
 * <p>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem373 {

    //    [1,1,2]
    //    [1,2,3]
    //    10
    // 算法有漏洞
    public List<List<Integer>> kSmallestPairsWrong(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int aS = 0;
        int bS = 0;
        if (null == nums1 || null == nums2 || 0 == nums1.length || 0 == nums2.length) {
            return result;
        }
        while (aS < nums1.length && bS < nums2.length) {
            result.add(Arrays.asList(new Integer[]{nums1[aS], nums2[bS]}));
            if (--k == 0) {
                break;
            }
            boolean top = true;
            if (aS + 1 < nums1.length && bS + 1 < nums2.length) {
                if (nums1[aS + 1] - nums1[aS] > nums2[bS + 1] - nums2[bS]) {
                    bS++;
                    top = false;
                } else if (nums1[aS + 1] - nums1[aS] < nums2[bS + 1] - nums2[bS]) {
                    aS++;
                } else {
                    if (aS > bS) {
                        bS++;
                    } else {
                        aS++;
                    }
                }
            } else if (aS + 1 < nums1.length) {
                aS++;
            } else {
                bS++;
                top = false;
            }
            if (top) {
                while (bS > 1 && bS < nums1.length && nums2[bS] == nums2[bS - 1]) {
                    bS--;
                }
            } else {
                while (aS > 1 && aS < nums2.length && nums1[aS] == nums1[aS - 1]) {
                    aS--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem373 problem = new Problem373();
        int[] nums11 = new int[]{1, 7, 11};
        int[] nums12 = new int[]{2, 4, 6};
        // [[1,2],[1,4],[1,6]]
        System.out.println(ArrayToStringUtil.twoDimension(problem.kSmallestPairs(nums11, nums12, 3)));
        System.out.println("##############");

        int[] nums21 = new int[]{1, 1, 2};
        int[] nums22 = new int[]{1, 2, 3};
        // [[1,2],[1,4],[1,6]]
        System.out.println(ArrayToStringUtil.twoDimension(problem.kSmallestPairs(nums21, nums22, 2)));
        System.out.println("##############");
        // [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
        System.out.println(ArrayToStringUtil.twoDimension(problem.kSmallestPairs(nums21, nums22, 10)));
        System.out.println("##############");

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            que.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(Arrays.asList(new Integer[]{cur[0], cur[1]}));
            if (cur[2] == nums2.length - 1) continue;
            que.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

}
