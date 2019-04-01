package com.chang.leetcode.math;

import com.chang.common.ArrayToStringUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Problem40Test {
    private Problem40 problem = new Problem40();

    @Test
    public void combinationSum2111111111() {
        int[] nums = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        List<List<Integer>> res = problem.combinationSum2(nums, 6);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");
    }

    @Test
    public void combinationSum2() {
        int[] nums = new int[]{};
        List<List<Integer>> res = problem.combinationSum2(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        res = problem.combinationSum2(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{2, 5, 2, 1, 2};
        res = problem.combinationSum2(nums, 5);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{2, 2, 2, 2};
        res = problem.combinationSum2(nums, 4);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");
    }

    @Test
    public void combinationSum2Sample() {
        int[] nums = new int[]{};
        List<List<Integer>> res = problem.combinationSum2Sample(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        res = problem.combinationSum2Sample(nums, 8);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{2, 5, 2, 1, 2};
        res = problem.combinationSum2Sample(nums, 5);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");

        nums = new int[]{2, 2, 2, 2};
        res = problem.combinationSum2Sample(nums, 4);
        System.out.println(ArrayToStringUtil.twoDimension(res));
        System.out.println("---------------------");
    }

}