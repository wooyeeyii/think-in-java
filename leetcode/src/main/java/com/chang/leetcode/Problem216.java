/*
 * 216. Combination Sum III
 * 
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * 
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combination(int k, int n, int start, List<Integer> list, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (!(k > 0 && n > 0 && start < 10)) {
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i > n) break;
            list.add(i);
            combination(k - 1, n - i, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Problem216 problem = new Problem216();
        System.out.println(ArrayToStringUtil.twoDimension(problem.combinationSum3(3, 7)));
        System.out.println(ArrayToStringUtil.twoDimension(problem.combinationSum3(3, 9)));
    }


}
