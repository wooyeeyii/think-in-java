package com.chang.leetcode.contest.biweekly15;

public class Problem5126 {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int number = arr[0];
        int count = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    number = arr[i - 1];
                }
                count = 1;
            }
        }

        if (arr.length > 1 && arr[len - 1] == arr[len - 2] && count > max) {
            return arr[len - 1];
        }

        return number;
    }

}
