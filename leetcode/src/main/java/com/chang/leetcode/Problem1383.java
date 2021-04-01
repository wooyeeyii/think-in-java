/*
 * 1383. Maximum Performance of a Team
 *
 * There are n engineers numbered from 1 to n and two arrays: speed and efficiency, where speed[i] and
 * efficiency[i] represent the speed and efficiency for the i-th engineer respectively.
 * Return the maximum performance of a team composed of at most k engineers, since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 *
 * Example 1:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4)
 * and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 *
 * Example 2:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team.
 * That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 *
 * Example 3:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 *
 * Constraints:
 * 1 <= n <= 10^5
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 10^5
 * 1 <= efficiency[i] <= 10^8
 * 1 <= k <= n
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1383 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{speed[i], efficiency[i]};
        }
        long max = 0, sumSpeed = 0;
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int[] en : engineers) {
            queue.add(en[0]);
            sumSpeed += en[0];
            if (queue.size() > k) {
                sumSpeed -= queue.poll();
            }
            max = Math.max(max, en[1] * sumSpeed);
        }
        return (int) (max % (long) (1e9 + 7));
    }

    public static void main(String[] args) {
        Problem1383 problem = new Problem1383();
        System.out.println(60 == problem.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
        System.out.println(68 == problem.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3));
        System.out.println(72 == problem.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4));
    }

}
