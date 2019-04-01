/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
package com.chang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        int pos = nums.length - 1;
        while(pos > 0 && nums[pos - 1] == nums[pos]) {
            pos--;
        }
        List<Integer> ori = new ArrayList<Integer>();
        for(int i = 0; i < pos; i++) {
            ori.add(nums[i]);
        }
        return permuteUniqueSub(ori, nums[pos], nums.length - pos);
    }

    private List<List<Integer>> permuteUniqueSub(List<Integer> nums, int newNum, int count) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.size() == 0) {
            List<Integer> oneNumList = new ArrayList<Integer>();
            for (int j = 0; j < count; j++) {
                oneNumList.add(newNum);
            }
            result.add(oneNumList);
            return result;
        }
        int end = nums.size() - 1;
        while(end > 0 && nums.get(end - 1) == nums.get(end)) {
            end--;
        }
        List<List<Integer>> resultPre = permuteUniqueSub(nums.subList(0, end), nums.get(end), nums.size() - end);
        for (List<Integer> listPre : resultPre) {
            List<List<Integer>> resultPreDiv = permuteDiv(listPre, newNum, count);
            result.addAll(resultPreDiv);
        }
        return result;
    }

    private List<List<Integer>> permuteDiv(List<Integer> subNum, int newNum, int count) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == subNum || subNum.size() == 0) {
            List<Integer> newNumInCount = new ArrayList<Integer>();
            for (int j = 0; j < count; j++) {
                newNumInCount.add(newNum);
            }
            result.add(newNumInCount);
            return result;
        }

        for(int i = 0; i <= count; i++) {
            List<Integer> front = new ArrayList<Integer>();
            for(int m = 0; m < i; m++) {
                front.add(newNum);
            }
            front.add(subNum.get(0));
            List<List<Integer>> resultPre = permuteDiv(subNum.subList(1, subNum.size()), newNum, count - i);
            for (List<Integer> listPre : resultPre) {
                List<Integer> list = new ArrayList<Integer>();
                list.addAll(front);
                list.addAll(listPre);
                result.add(list);
            }
        }
        return result;
    }


    /**
     * method which have the most votes in discuss of leetcode
     **/
    public List<List<Integer>> permuteUniqueSample(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


}
