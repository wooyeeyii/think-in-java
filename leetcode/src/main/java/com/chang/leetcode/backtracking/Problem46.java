/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
package com.chang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 0) {
            return result;
        }
        return permuteSub(nums, nums.length - 1);
    }
    private List<List<Integer>> permuteSub(int[] nums, int pos) {
        if (pos == 0) {
            List<List<Integer>> result1 = new ArrayList<List<Integer>>();
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(nums[pos]);
            result1.add(list1);
            return result1;
        }

        List<List<Integer>> resultPre = permuteSub(nums, pos - 1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int newNum = nums[pos];
        for (int i = 0; i <= resultPre.get(0).size(); i++) {
            for (List<Integer> listPre : resultPre) {
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(listPre);
                list.add(i, newNum);
                result.add(list);
            }
        }
        return result;
    }

    /**
     * according to Problem47's idea
     * may have this solution
     */
    public List<List<Integer>> permuteSample(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        recursive(nums, used, list, result);
        return result;
    }
    private void recursive(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            recursive(nums, used, list, result);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
