/*
 * 1238. Circular Permutation in Binary Representation
 *
 * Given 2 integers n and start. Your task is return any permutation p of (0,1,2.....,2^n -1) such that :
 *
 * p[0] = start
 * p[i] and p[i+1] differ by only one bit in their binary representation.
 * p[0] and p[2^n -1] must also differ by only one bit in their binary representation.
 *
 *
 * Example 1:
 * Input: n = 2, start = 3
 * Output: [3,2,0,1]
 * Explanation: The binary representation of the permutation is (11,10,00,01).
 * All the adjacent element differ by one bit. Another valid permutation is [3,1,0,2]
 *
 * Example 2:
 * Input: n = 3, start = 2
 * Output: [2,6,7,5,4,0,1,3]
 * Explanation: The binary representation of the permutation is (010,110,111,101,100,000,001,011).
 *
 *
 * Constraints:
 * 1 <= n <= 16
 * 0 <= start < 2 ^ n
 */
package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.List;

public class Problem1238 {

    // grey code
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= n; i++) {
            List<Integer> newL = new ArrayList<>();
            for (int j = list.size() - 1; j >= 0; j--) {
                newL.add((list.get(j) << 1) + 1);
                list.set(j, list.get(j) << 1);
            }
            list.addAll(newL);
        }

        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == start) {
                idx = i;
                break;
            }
        }
        for (int i = idx; i < list.size(); i++) {
            res.add(list.get(i));
        }
        for (int i = 0; i < idx; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1238 problem = new Problem1238();
        // [3,2,0,1] or [3,1,0,2]
        List<Integer> res1 = problem.circularPermutation(2, 3);
        // [2,6,7,5,4,0,1,3]
        List<Integer> res2 = problem.circularPermutation(3, 2);
    }

}


