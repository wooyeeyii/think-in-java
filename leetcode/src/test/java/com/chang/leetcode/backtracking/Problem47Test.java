package com.chang.leetcode.backtracking;

import com.chang.common.ArrayToStringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem47Test {

    private Problem47 problem = new Problem47();

    @Test
    public void permuteUnique() {
//        int[] nums = new int[] {2, 2, 1, 1};
        int[] nums = new int[] {2, 2, 1, 1};
        List<List<Integer>> result = problem.permuteUnique(nums);
        System.out.println(ArrayToStringUtil.twoDimension(result));
    }

    @Test
    public void permuteUniqueSample() {
        int[] nums = new int[] {2, 2, 1, 1};
        List<List<Integer>> result = problem.permuteUniqueSample(nums);
        System.out.println(ArrayToStringUtil.twoDimension(result));
    }

    @Test
    public void subListTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<Integer> sub = list.subList(0, 2); //sub.size() = 0
        System.out.println(ArrayToStringUtil.oneDimension(sub));
    }


}