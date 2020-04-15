package com.chang.leetcode.backtracking;

import com.chang.common.ArrayToStringUtil;
import org.junit.Test;

import java.util.List;

public class Problem46Test {

    private Problem46 problem = new Problem46();

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = problem.permute(nums);
        System.out.println("[");
        for (List<Integer> list : result) {
            System.out.print("[");
            for (Integer in : list) {
                System.out.print(in + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    @Test
    public void permuteSample() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = problem.permuteSample(nums);
        String res = ArrayToStringUtil.twoDimension(result);
        System.out.println(res);
    }

}