/*
 * 1512. Number of Good Pairs
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
package com.chang.leetcode.contest.weekly197;

public class Problem1512 {

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numIdenticalPairsExample(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a : A) {
            res += (count[a]++);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1512 problem = new Problem1512();
        System.out.println(4 == problem.numIdenticalPairsExample(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(6 == problem.numIdenticalPairsExample(new int[]{1, 1, 1, 1}));
    }

}
