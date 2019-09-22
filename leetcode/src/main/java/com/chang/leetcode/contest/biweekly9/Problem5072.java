package com.chang.leetcode.contest.biweekly9;

import java.util.Arrays;

public class Problem5072 {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        for(; i < arr.length && sum <= 5000; i++) {
            sum += arr[i];
        }
        return sum > 5000 ? i - 1: i;
    }

    public static void main(String[] args) {
        Problem5072 problem = new Problem5072();
        System.out.println(4 == problem.maxNumberOfApples(new int[]{100, 200, 150, 1000}));
        System.out.println(5 == problem.maxNumberOfApples(new int[]{900, 950, 800, 1000, 700, 800}));
    }
}
