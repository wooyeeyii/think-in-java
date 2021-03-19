/*
 * 与39不同的地方：
 * 每个数只能用一次，但给的数可能重复
 * 所有数为正数
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
package com.chang.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        boolean[] used = new boolean[candidates.length];
        combinationSum2Cur(candidates, 0, target, used, list, result);
        return result;
    }

    private void combinationSum2Cur(int[] candidates, int pos, int target, boolean[] used,
                                    List<Integer> list, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList<Integer>(list));
        }
        if (target < candidates[pos]) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (used[i]) continue;
            /*
             * 下面这句判断的意思
             * 同样的数，若前面的一个没用过，则直接跳过
             * 也就是说，若是相同的数，只有前面的都用了，才轮到当前的数(大小和前面的一样)被使用
             */
            if (i > pos && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            if (candidates[i] > target) break;
            list.add(candidates[i]);
            used[i] = true;
            combinationSum2Cur(candidates, i, target - candidates[i], used, list, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    /*
     * 上面为初次代码，借鉴leetcode， 根本不需要used来做判断，因为
     * 首先，下次递归只是用后面的数，后面的都是没用过的
     * 其次，举例说明
     * 1， 2， 2， 2， 3， 4, 5， 5， 5 ...
     * 当使用第二个2时，后面还有 2， 2， 3， 4， 可以选择，、
     * 使用第三个2时，其实上一步已经包含了使用2的所用情况，直接跳过就OK了
     * 代码如下
     */
    public List<List<Integer>> combinationSum2Sample(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        combinationSum2CurSample(candidates, 0, target, list, result);
        return result;
    }

    private void combinationSum2CurSample(int[] candidates, int pos, int target,
                                          List<Integer> list, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList<Integer>(list));
        }
        if (pos >= candidates.length || target < candidates[pos]) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            list.add(candidates[i]);
            combinationSum2CurSample(candidates, i + 1, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
