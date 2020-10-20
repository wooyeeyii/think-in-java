/**
 * 1626. Best Team With No Conflicts
 *
 * You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score.
 * The score of the team is the sum of scores of all the players in the team.
 *
 * However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player
 * has a strictly higher score than an older player. A conflict does not occur between players of the same age.
 *
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player,
 * respectively, return the highest overall score of all possible basketball teams.
 *
 * Example 1:
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 *
 * Example 2:
 * Input: scores = [4,5,6,5], ages = [2,1,2,1]
 * Output: 16
 * Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
 *
 * Example 3:
 * Input: scores = [1,2,3,5], ages = [8,9,10,1]
 * Output: 6
 * Explanation: It is best to choose the first 3 players.
 *
 *
 * Constraints:
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 */
package com.chang.leetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
//        List<Integer> list = new ArrayList<>();
//        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
//            if (a[0] - b[0] == 0) {
//                return a[1] - b[1];
//            } else {
//                return a[0] - b[0];
//            }
//        }
//        );
//        for (int i = 0; i < len; i++) {
//            q.offer(new int[]{ages[i], scores[i]});
//        }
//
//        while (!q.isEmpty()) {
//            list.add(q.poll()[1]);
//        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new int[]{ages[i], scores[i]});
        }
        list.sort((a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[len];
        dp[0] = list.get(0)[1];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            int preMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j)[1] <= list.get(i)[1]) {
                    preMax = Math.max(preMax, dp[j]);
                }
            }
            dp[i] = list.get(i)[1] + preMax;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Problem1626 problem = new Problem1626();
        System.out.println(problem.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(problem.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
    }

}
