/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
package com.chang.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        combinationSumCur(candidates, 0, target, list, result);
        return result;
    }

    private void combinationSumCur(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList<Integer>(list));
        }
        if (target < candidates[0]) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            combinationSumCur(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

}
