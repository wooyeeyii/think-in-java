package com.chang.leetcode.contest.weekly152;

import java.util.ArrayList;
import java.util.List;

public class Problem5174 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(calories.length < k) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += calories[i];
        }

        int point = sum > upper ? 1 : (sum < lower ? -1 : 0);
        for(int i = k; i < calories.length; i++) {
            sum = sum + calories[i] - calories[i - k];
            point += sum > upper ? 1 : (sum < lower ? -1 : 0);
        }

        return point;
    }

    public static void main(String[] args) {
        Problem5174 problme = new Problem5174();
        System.out.println(0 == problme.dietPlanPerformance(new int[]{1,2,3,4,5}, 1, 3, 3));
        System.out.println(1 == problme.dietPlanPerformance(new int[]{3, 2 }, 2, 0, 1));
        System.out.println(0 == problme.dietPlanPerformance(new int[]{6, 5, 0, 0}, 2, 1, 5));
        System.out.println(3 == problme.dietPlanPerformance(new int[]{6,13,8,7,10,1,12,11}, 6 , 5, 37));
    }


}
