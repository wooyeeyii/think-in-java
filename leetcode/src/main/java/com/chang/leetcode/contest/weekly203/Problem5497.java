package com.chang.leetcode.contest.weekly203;

import java.util.HashMap;
import java.util.Map;

public class Problem5497 {

    // Time Limit Exceed
    public int findLatestStepTooSlow(int[] arr, int m) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, len);
        if (len == m) return len;
        for (int i = len - 1; i >= 0; i--) {
            arr[i] -= 1;
            int start = -1;
            for (int k = arr[i]; k >= 0; k--) {
                if (map.getOrDefault(k, -1) > arr[i]) {
                    start = k;
                }
            }

            int last = map.get(start);
            if (arr[i] < len - 1 && arr[i] + 1 < map.get(start)) {
                map.put(arr[i] + 1, map.get(start));
            }
            if (arr[i] > start) {
                map.put(start, arr[i]);
            } else {
                map.remove(start);
            }

            if ((map.containsKey(start) && arr[i] - start == m) ||
                    (last - arr[i] - 1 == m)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem5497 problem = new Problem5497();
        System.out.println(problem.findLatestStep(new int[]{3, 2, 4, 1, 5}, 1));
        System.out.println(problem.findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
        System.out.println(problem.findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
        System.out.println(problem.findLatestStep(new int[]{1}, 1));
        System.out.println(problem.findLatestStep(new int[]{2, 1}, 2));
    }

    public int findLatestStep(int[] A, int m) {
        int res = -1, n = A.length;
        int[] length = new int[n + 2], count = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = A[i], left = length[a - 1], right = length[a + 1];
            length[a] = length[a - left] = length[a + right] = left + right + 1;
            count[left]--;
            count[right]--;
            count[length[a]]++;
            if (count[m] > 0)
                res = i + 1;
        }
        return res;
    }

}