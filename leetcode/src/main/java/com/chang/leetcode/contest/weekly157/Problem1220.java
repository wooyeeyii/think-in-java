/*
 * 1220. Count Vowels Permutation
 *
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 *
 * Example 2:
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 *
 * Example 3:
 * Input: n = 5
 * Output: 68
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 10^4
 */
package com.chang.leetcode.contest.weekly157;

import java.util.Arrays;

public class Problem1220 {

    public int countVowelPermutation(int n) {
        int HUGE = (int) Math.pow(10, 9) + 7;
        int[][] flag = new int[5][5];
        flag[0] = new int[]{0, 1, 1, 0, 1};
        flag[1] = new int[]{1, 0, 1, 0, 0};
        flag[2] = new int[]{0, 1, 0, 1, 0};
        flag[3] = new int[]{0, 0, 1, 0, 0};
        flag[4] = new int[]{0, 0, 1, 1, 0};

        int[] before = new int[5];
        Arrays.fill(before, 1);
        for (int i = 2; i <= n; i++) {
            int[] cur = new int[5];
            for (int j = 0; j < 5; j++) {
                int count = 0;
                for (int m = 0; m < 5; m++) {
                    count = (count + (before[m] * flag[j][m]) % HUGE) % HUGE;
                }
                cur[j] = count;
            }
            before = cur;
        }

        int sum = 0;
        for (int m : before) {
            sum = (sum + (m % HUGE)) % HUGE;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem1220 problem = new Problem1220();
        System.out.println(5 == problem.countVowelPermutation(1));
        System.out.println(10 == problem.countVowelPermutation(2));
        System.out.println(68 == problem.countVowelPermutation(5));
    }


}
