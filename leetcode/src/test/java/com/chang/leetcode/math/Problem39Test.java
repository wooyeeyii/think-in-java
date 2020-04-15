package com.chang.leetcode.math;

import com.chang.common.ArrayToStringUtil;
import org.junit.Test;

import java.util.List;

public class Problem39Test {

    private Problem39 problem = new Problem39();

    @Test
    public void combinationSum() {
        int[] nums = new int[]{};
        List<List<Integer>> res = problem.combinationSum(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));

        nums = new int[]{2, 3, 6, 7};
        res = problem.combinationSum(nums, 7);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println();

        nums = new int[]{2, 3, 5};
        res = problem.combinationSum(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println();
    }

}