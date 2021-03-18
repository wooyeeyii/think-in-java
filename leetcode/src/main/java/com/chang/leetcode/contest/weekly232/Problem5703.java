package com.chang.leetcode.contest.weekly232;

import java.util.PriorityQueue;

public class Problem5703 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        if (null == classes || 0 == classes.length || null == classes[0] || 0 == classes[0].length) {
            return 0;
        }

        int m = classes.length;
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0] > 0 ? 1 : -1);
        for (int i = 0; i < m; i++) {
            double[] record = new double[3];
            int[] nums = classes[i];
            record[0] = ((double) (nums[1] - nums[0])) / nums[1] / (nums[1] + 1);
            record[1] = nums[0];
            record[2] = nums[1];
            queue.add(record);
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] max = queue.poll();
            max[1] = max[1] + 1;
            max[2] = max[2] + 1;
            max[0] = (max[2] - max[1]) / max[2] / (max[2] + 1);
            queue.add(max);
        }

        double pass = 0;
        while (!queue.isEmpty()) {
            double[] n = queue.poll();
            pass += (n[1] / n[2]);
        }

        return pass / m;
    }

    public static void main(String[] args) {
        Problem5703 problem = new Problem5703();
        // 0.78333
        System.out.println(problem.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        // 0.53485
        System.out.println(problem.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
    }

}
