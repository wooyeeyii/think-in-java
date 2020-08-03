package com.chang.leetcode.contest.weekly200.virtual;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1535 {

    public int getWinner(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(arr).forEach(n -> queue.add(n));
        if (k >= arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }

        int win = 0;
        int flag = queue.poll();
        while (win < k) {
            int top = queue.poll();
            if (top > flag) {
                win = 1;
                queue.offer(flag);
                flag = top;
            } else {
                win++;
                queue.offer(top);
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Problem1535 problem = new Problem1535();
        System.out.println(5 == problem.getWinnerExample(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(3 == problem.getWinnerExample(new int[]{3, 2, 1}, 10));
        System.out.println(9 == problem.getWinnerExample(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(99 == problem.getWinnerExample(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }

    public int getWinnerExample(int[] arr, int k) {
        if (k == 1) return Math.max(arr[0], arr[1]);
        int n = arr.length, cnt = 0, cur = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > cur) {
                cnt = 1;
                cur = arr[i];
            } else {
                cnt++;
                if (cnt == k) return cur;
            }
        }
        return cur;
    }
}
