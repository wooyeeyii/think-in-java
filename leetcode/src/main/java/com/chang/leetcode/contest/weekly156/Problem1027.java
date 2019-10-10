/**
 * 1207. Unique Number of Occurrences
 *
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 *
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 *
 * Example 2:
 * Input: arr = [1,2]
 * Output: false
 *
 * Example 3:
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 */
package com.chang.leetcode.contest.weekly156;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1027 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(!set.add(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1027 problem = new Problem1027();
        System.out.println(problem.uniqueOccurrences(new int[] {1,2,2,1,1,3}));
        System.out.println(!problem.uniqueOccurrences(new int[] {1,2}));
        System.out.println(problem.uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
