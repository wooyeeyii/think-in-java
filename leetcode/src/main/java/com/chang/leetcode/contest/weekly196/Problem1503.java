/*
 * 1503. Last Moment Before All Ants Fall Out of a Plank
 *
 * We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with speed 1 unit per second.
 * Some of the ants move to the left, the other move to the right.
 * When two ants moving in two different directions meet at some point, they change their directions and continue moving again.
 * Assume changing directions doesn't take any additional time.
 * When an ant reaches one end of the plank at a time t, it falls out of the plank imediately.
 * Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right.
 * Return the moment when the last ant(s) fall out of the plank.
 */
package com.chang.leetcode.contest.weekly196;

public class Problem1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        for (int l : left) {
            leftMax = Math.max(l, leftMax);
        }
        for (int r : right) {
            rightMin = Math.min(r, rightMin);
        }

        return Math.max(leftMax, n - rightMin);
    }

    public static void main(String[] args) {
        Problem1503 problem = new Problem1503();
        System.out.println(problem.getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(problem.getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(problem.getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{}));
        System.out.println(problem.getLastMoment(9, new int[]{5}, new int[]{4}));
        System.out.println(problem.getLastMoment(6, new int[]{6}, new int[]{0}));
    }

}
