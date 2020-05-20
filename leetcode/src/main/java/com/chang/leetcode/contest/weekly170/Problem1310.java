/**
 * 1310. XOR Queries of a Subarray
 * <p>
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
 * for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ).
 * Return an array containing the result for the given queries.
 * <p>
 * Example 1:
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8]
 * Explanation:
 * The binary representation of the elements in the array are:
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * <p>
 * [3,3] = 8
 * Example 2:
 * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * Output: [8,0,4,4]
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 */
package com.chang.leetcode.contest.weekly170;

public class Problem1310 {

    public int[] xorQueriesTooSlow(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j < queries[i][1]; j++) {
                result[i] ^= arr[j];
            }
        }
        return result;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (0 == queries[i][0]) {
                result[i] = dp[queries[i][1]];
            } else {
                result[i] = dp[queries[i][1]] ^ dp[queries[i][0] - 1];
            }
        }
        return result;
    }


}