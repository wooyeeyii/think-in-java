/*
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {
    /*
     * 递推公式
     * [n,k] = [n-1,k-2]和n的组合 + [n-1,k]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < k || k < 0) {
            return result;
        }
        // 看这里..... k是0的话添加空串以供后序使用
        if (0 == k) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<List<Integer>> preResult = combine(n - 1, k - 1);
        preResult.forEach(list -> list.add(n));
        result.addAll(preResult);
        result.addAll(combine(n - 1, k));

        return result;
    }

    /*
     * Backtracking Solution 回溯算法
     */
    public List<List<Integer>> combineExample(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }


    public static void main(String[] args) {
        Problem77 problem = new Problem77();
        System.out.println(ArrayToStringUtil.twoDimension(problem.combineExample(4, 2)));
    }
}
