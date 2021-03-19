/*
 * 1235. Maximum Profit in Job Scheduling
 * 
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take such that
 * there are no 2 jobs in the subset with overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 * 
 * 
 * Example 1:
 * 
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * 
 * Example 2:
 * 
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * 
 * Example 3:
 * 
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 * 
 * 
 * Constraints:
 * 
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
 * 1 <= startTime[i] < endTime[i] <= 10^9
 * 1 <= profit[i] <= 10^4
 */
package com.chang.leetcode.contest.weekly159;

import java.util.*;

public class Problem1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = endTime.length;
        int maxEnd = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < len; i++) {
            maxEnd = Math.max(maxEnd, endTime[i]);
            int[] newA = new int[]{endTime[i], startTime[i], profit[i]};
            queue.offer(newA);
        }

        int max = 0;
        int[] dp = new int[maxEnd + 1];
        dp[0] = 0;
        int[] curInfo = queue.poll();
        for (int i = 1; i <= maxEnd && null != curInfo; i++) {
            if (i == curInfo[0]) {
                dp[i] = Math.max(dp[i - 1], dp[curInfo[1]] + curInfo[2]);
                max = Math.max(max, dp[i]);
                int[] nextInfo = queue.poll();
                while (null != nextInfo && nextInfo[0] == curInfo[0]) {
                    dp[i] = Math.max(dp[i], dp[nextInfo[1]] + nextInfo[2]);
                    max = Math.max(max, dp[i]);
                    nextInfo = queue.poll();
                }
                curInfo = nextInfo;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Problem1235 problem = new Problem1235();
        System.out.println(120 == problem.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        System.out.println(150 == problem.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        System.out.println(6 == problem.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
        System.out.println(7 == problem.jobScheduling(new int[]{1, 2, 2, 3}, new int[]{2, 5, 3, 4}, new int[]{3, 4, 1, 2}));
        System.out.println(18 == problem.jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
        System.out.println(18 == problem.jobScheduling(new int[]{11, 10, 14, 24, 5, 9, 3, 17, 27, 20}, new int[]{20, 23, 22, 29, 9, 13, 9, 23, 28, 30}, new int[]{2, 2, 3, 2, 4, 3, 4, 4, 7, 2}));
    }

    public int jobSchedulingExample(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] items = new int[len][3];
        for (int i = 0; i < len; i++) {
            items[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(items, (a1, a2) -> a1[1] - a2[1]);

        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        // init value to avoid IndexOutBoundExp
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            // find previous endTime index
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            int currProfit = dpProfit.get(prevIdx) + p, maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }
}
