package com.chang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int[][] workers = new int[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new int[]{quality[i], wage[i]};
        }
        Arrays.sort(workers, (a, b) -> b[0] * a[1] - b[1] * a[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        double min = Double.MAX_VALUE;
        int sumQuality = 0;
        for (int[] w : workers) {
            queue.add(w[0]);
            sumQuality += w[0];
            if (queue.size() > k) {
                sumQuality -= queue.poll();
            }
            if (k == queue.size()) {
                min = Math.min(min, (double) w[1] / w[0] * sumQuality);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Problem857 problem = new Problem857();
        System.out.println(problem.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(problem.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

}
