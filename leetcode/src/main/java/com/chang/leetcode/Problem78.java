/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list0 = new ArrayList<Integer>();
        result.add(list0);
        int length = nums.length;
        for(int i = 1; i <= length; i++) {
            List<List<Integer>> resultK = new ArrayList<List<Integer>>();
            subsetsDiv(nums, i, 0, new ArrayList<Integer>(), resultK);
            result.addAll(resultK);
        }
        return result;
    }

    private void subsetsDiv(int[]nums, int k, int start, List<Integer> tmp, List<List<Integer>> resultK) {
        if(k==0) {
            resultK.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=start;i<nums.length;i++) {
            tmp.add(nums[i]);
            subsetsDiv(nums, k-1, i+1, tmp, resultK);
            tmp.remove(tmp.size()-1);
        }
    }
}
