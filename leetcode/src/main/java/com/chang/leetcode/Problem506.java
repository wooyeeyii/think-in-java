/**
 * 506. Relative Ranks
 * <p>
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * <p>
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem506 {

    public String[] findRelativeRanks(int[] nums) {
        if (null == nums) {
            return null;
        }

        String[] result = new String[nums.length];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }

        int rank = 1;
        while (queue.size() > 0) {
            int[] tmp = queue.poll();
            if (1 == rank) {
                result[tmp[1]] = "Gold Medal";
            } else if (2 == rank) {
                result[tmp[1]] = "Silver Medal";
            } else if (3 == rank) {
                result[tmp[1]] = "Bronze Medal";
            } else {
                result[tmp[1]] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem506 problem = new Problem506();
        int[] nums1 = new int[]{5, 4, 3, 2, 1, 10};
        String[] res = problem.findRelativeRanks(nums1);
    }

    // without sorting
    public String[] findRelativeRanksExample(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max) max = i;
        }
        // score chart
        int[] hash = new int[max + 1];
        //          1,2,3,4,5
        //  index.  4,3,5,2,1
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }
        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = place + "";
                }
                place++;
            }
        }
        return result;
    }

    public String[] findRelativeRanksOtherCode(int[] nums) {
        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}
