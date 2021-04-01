/*
 * 630. Course Schedule III
 *
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day.
 * A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
 *
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 *
 * Example:
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation:
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 *
 * Note:
 * The integer 1 <= d, t, n <= 10,000.
 * You can't take two courses simultaneously.
 */
package com.chang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem630 {

    public int scheduleCourseSelf(int[][] courses) {
        PriorityQueue<int[]> classes = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> durations = new PriorityQueue<>((a, b) -> b - a);
        int sumDurations = 0;

        classes.addAll(Arrays.asList(courses));

        while (!classes.isEmpty()) {
            int[] c = classes.poll();
            if (sumDurations + c[0] <= c[1]) {
                sumDurations += c[0];
                durations.add(c[0]);
            } else if (null != durations.peek()) {
                int p = durations.peek();
                if (p > c[0]) {
                    durations.poll();
                    durations.add(c[0]);
                    sumDurations = sumDurations - p + c[0];
                }
            }
        }

        return durations.size();
    }

    public static void main(String[] args) {
        Problem630 problem = new Problem630();
        System.out.println(problem.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }

    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> durations = new PriorityQueue<>((a, b) -> b - a);
        int sumDurations = 0;

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        for (int[] c : courses) {
            if (sumDurations + c[0] <= c[1]) {
                sumDurations += c[0];
                durations.add(c[0]);
            } else if (null != durations.peek()) {
                int p = durations.peek();
                if (p > c[0]) {
                    durations.poll();
                    durations.add(c[0]);
                    sumDurations = sumDurations - p + c[0];
                }
            }
        }

        return durations.size();
    }

}
