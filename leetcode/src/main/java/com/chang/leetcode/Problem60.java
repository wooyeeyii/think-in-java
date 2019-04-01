/**
 * 60. Permutation Sequence
 * <p>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * <p>
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * <p>
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem60 {
    public String getPermutation(int n, int k) {
        String result = "";
        List<Integer> digit = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            digit.add(i);
        }
        int[] count = new int[n + 1];
        count[0] = 0;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i - 1] * i;
        }
        int i = 0;
        while (i < n) {
            if (0 != count[n - 1 - i] && k > count[n - 1 - i]) {
                int idx = k / count[n - 1 - i];
                k %= count[n - 1 - i];
                idx = k == 0 ? idx - 1 : idx;
                k = k == 0 ? count[n - 1 - i] : k;
                result += String.valueOf(digit.get(idx));
                digit.remove(idx);
            } else {
                result += String.valueOf(digit.get(0));
                digit.remove(0);
            }

            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem60 problem = new Problem60();
        System.out.println("213".equals(problem.getPermutation(3, 3)));
        System.out.println("2314".equals(problem.getPermutation(4, 9)));
        String s2 = problem.getPermutation(2, 2);
        System.out.println(s2);
        System.out.println("21".equals(s2));
        String s3 = problem.getPermutation(9, 362880);
        System.out.println(s3);
        System.out.println("987654321".equals(s3));
    }

    public String getPermutationExample(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
}
