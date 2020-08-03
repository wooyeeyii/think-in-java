package com.chang.leetcode.contest.weekly200.virtual;

public class Problem1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[k] - arr[j]) > b || Math.abs(arr[k] - arr[i]) > c) {
                        continue;
                    } else {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
