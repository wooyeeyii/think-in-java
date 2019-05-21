/**
 * 275. H-Index II
 *
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example:
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 *
 * Note:
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * Follow up:
 *     This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 *     Could you solve it in logarithmic time complexity?
 */
package com.chang.leetcode;

public class Problem275 {

    public int hIndex(int[] citations) {
        int length = 0;
        if (null == citations || 0 == (length = citations.length)) {
            return 0;
        }

        int left = 0;
        int right = length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if((length - middle) == citations[middle]) {
                return length - middle;
            } else if((length - middle) < citations[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return length - left;
    }


    public static void main(String[] args) {
        Problem275 problem = new Problem275();
        int[] data1 = new int[]{0};
        System.out.println(0 == problem.hIndex(data1));

        int[] data2 = new int[]{0, 1, 3, 5, 6};
        System.out.println(3 == problem.hIndex(data2));

        int[] data3 = new int[]{1};
        System.out.println(1 == problem.hIndex(data3));

    }

    public int hIndexExample(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }

}
