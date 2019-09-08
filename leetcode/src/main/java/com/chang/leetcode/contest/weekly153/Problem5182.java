package com.chang.leetcode.contest.weekly153;

import java.util.ArrayList;
import java.util.List;

public class Problem5182 {

    public int maximumSum(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                list.add(sum);
                sum = 0;
                list.add(arr[i]);
            } else {
                sum += arr[i];
            }
        }
        if(arr[arr.length - 1] >= 0) {
            list.add(sum);
        }



    }

    public static void main(String[] args) {
        Problem5182 problem = new Problem5182();
        System.out.println(4 == problem.maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(3 == problem.maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(-1 == problem.maximumSum(new int[]{-1, -1, -1, -1}));
    }
}
