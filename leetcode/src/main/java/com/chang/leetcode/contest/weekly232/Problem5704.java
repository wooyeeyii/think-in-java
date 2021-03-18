package com.chang.leetcode.contest.weekly232;

import java.util.PriorityQueue;

public class Problem5704 {

    public int maximumScore(int[] nums, int k) {
        int max = 0, begin = 0, end = nums.length - 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }

        while (!queue.isEmpty()) {
            if (begin > end) {
                break;
            }

            int[] first = queue.poll();
            if (first[1] < begin || first[1] > end) {
                continue;
            }

            max = Math.max(max, (end - begin + 1) * first[0]);

            if (first[1] <= k) {
                begin = first[1] + 1;
                while (!queue.isEmpty() && queue.peek()[0] == first[0] && queue.peek()[1] <= k) {
                    begin = queue.peek()[1] + 1;
                    queue.poll();
                }
            }
            if (first[1] >= k) {
                end = first[1] - 1;
                if (!queue.isEmpty() && queue.peek()[0] == first[0] && queue.peek()[1] >= k) {
                    end = Math.min(end, queue.peek()[1] - 1);
                    queue.poll();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem5704 problem = new Problem5704();
        // 15
        System.out.println(problem.maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        // 20
        System.out.println(problem.maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }

}
