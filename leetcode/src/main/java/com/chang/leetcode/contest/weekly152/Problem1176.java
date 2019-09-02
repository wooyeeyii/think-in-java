/**
 * 1176. Diet Plan Performance
 *
 * A dieter consumes calories[i] calories on the i-th day.  For every consecutive sequence of k days, they look at T,
 * the total calories consumed during that sequence of k days:
 *
 * If T < lower, they performed poorly on their diet and lose 1 point;
 * If T > upper, they performed well on their diet and gain 1 point;
 * Otherwise, they performed normally and there is no change in points.
 * Return the total number of points the dieter has after all calories.length days.
 *
 * Note that: The total points could be negative.
 *
 * Example 1:
 * Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 * Output: 0
 * Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.
 *
 * Example 2:
 * Input: calories = [3,2], k = 2, lower = 0, upper = 1
 * Output: 1
 * Explaination: calories[0] + calories[1] > upper, total points = 1.
 *
 * Example 3:
 * Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
 * Output: 0
 * Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
 */
package com.chang.leetcode.contest.weekly152;

public class Problem1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (calories.length < k) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }

        int point = sum > upper ? 1 : (sum < lower ? -1 : 0);
        for (int i = k; i < calories.length; i++) {
            sum = sum + calories[i] - calories[i - k];
            point += sum > upper ? 1 : (sum < lower ? -1 : 0);
        }

        return point;
    }

    public static void main(String[] args) {
        Problem1176 problme = new Problem1176();
        System.out.println(0 == problme.dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3));
        System.out.println(1 == problme.dietPlanPerformance(new int[]{3, 2}, 2, 0, 1));
        System.out.println(0 == problme.dietPlanPerformance(new int[]{6, 5, 0, 0}, 2, 1, 5));
        System.out.println(3 == problme.dietPlanPerformance(new int[]{6, 13, 8, 7, 10, 1, 12, 11}, 6, 5, 37));
    }


}
