package com.chang.leetcode.contest.weekly157;

public class Problem5213 {

    public int minCostToMoveChips(int[] chips) {
        int evenCount = 0;
        int oddCount = 0;
        for(int i = 0; i < chips.length; i++) {
            if(chips[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return evenCount > oddCount ? oddCount : evenCount;
    }

    public static void main(String[] args) {
        Problem5213 problem = new Problem5213();
        System.out.println(1 == problem.minCostToMoveChips(new int[] {1, 2, 3}));
        System.out.println(2 == problem.minCostToMoveChips(new int[] {2,2,2,3,3}));
    }


}
