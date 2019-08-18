/**
 * 477. Total Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions
 * at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Example:
 * Input: 4, 14, 2
 * Output: 6
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 */
package com.chang.leetcode;

public class Problem477 {

    // Time Limit Exceeded
    public int totalHammingDistanceSlow(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                count += countOnes(nums[i] ^ nums[j]);
            }
        }
        return count;
    }
    private int countOnes(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int total = 0;
        for (int i = 0; i < 31; i++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> i) & 1;
            }

            total += bitCount * (nums.length - bitCount);
        }

        return total;
    }

    public static void main(String[] args) {
        Problem477 problem = new Problem477();
        int[] nums1 = new int[]{4, 14, 2};
        System.out.println(6 == problem.totalHammingDistance(nums1));
    }



}
