/*
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, 0, used);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start, boolean[] used) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(list, tempList, nums, i + 1, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Problem90 problem = new Problem90();
        int[] nums1 = new int[]{1, 2, 2, 2};
        System.out.println(ArrayToStringUtil.twoDimension(problem.subsetsWithDup(nums1)));
        System.out.println("###################");
    }
}
