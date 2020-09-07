/**
 * 1578. Minimum Deletion Cost to Avoid Repeating Letters
 *
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character,
 * the costs of deleting other characters will not change.
 *
 * Example 1:
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 *
 * Example 2:
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 *
 * Example 3:
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 *
 * Constraints:
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s contains only lowercase English letters.
 */
package com.chang.leetcode.contest.weekly205;

public class Problem1578 {

    public int minCost(String s, int[] cost) {
        int min = 0;
        int maxCost = 0;
        boolean dup = false;
        for (int i = 0; i < cost.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxCost = Math.max(maxCost, cost[i]);
                min += cost[i];
                dup = true;
            } else {
                if (dup) {
                    maxCost = Math.max(maxCost, cost[i]);
                    min += cost[i];
                    min -= maxCost;
                    maxCost = 0;
                    dup = false;
                }
            }
        }

        if (dup) {
            maxCost = Math.max(maxCost, cost[s.length() - 1]);
            min += cost[s.length() - 1];
            min -= maxCost;
        }

        return min;
    }

    public static void main(String[] args) {
        Problem1578 problem = new Problem1578();
        System.out.println(problem.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(problem.minCost("abc", new int[]{1, 2, 3}));
        System.out.println(problem.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(26 == problem.minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
        System.out.println(problem.minCost("bbbaaa", new int[]{4, 9, 3, 8, 8, 9}));
    }

    public int minCostExample(String s, int[] cost) {
        int ans = 0;
        for (int x : cost) ans += x;
        char ch = ' ';
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) max = Math.max(max, cost[i]);
            else {
                ans -= max;
                ch = s.charAt(i);
                max = cost[i];
            }
        }
        ans -= max;
        return ans;
    }

}
