/**
 * 376. Wiggle Subsequence
 *
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 *
 * Example 1:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 *
 * Example 2:
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 *
 * Example 3:
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 *
 * Follow up:
 * Can you do it in O(n) time?
 */
package com.chang.leetcode;

public class Problem376 {

    public int wiggleMaxLength(int[] nums) {
        int len = 0;
        if(null == nums || 0 == (len = nums.length)) {
            return 0;
        }
        int idx = 1;
        while(idx < len && nums[idx - 1] == nums[idx]) {
            idx++;
        }
        if(idx == len) {
            return 1;
        }
        int second = idx;
        int count = 1;
        while(idx < len) {
            while(idx < len && nums[idx] - nums[idx - 1] >= 0) {
                idx++;
            }
            count++;
            if(idx >= len) {
                break;
            }
            while(idx < len && nums[idx] - nums[idx - 1] <= 0) {
                idx++;
            }
            count++;
        }

        return nums[second] > nums[0] ? count : count - 1;
    }

    public static void main(String[] args) {
        Problem376 problem = new Problem376();

        int[] nums0 = new int[] {1};
        System.out.println(1 == problem.wiggleMaxLength(nums0));

        int[] nums01 = new int[] {1,1,1,1,1,1};
        System.out.println(1 == problem.wiggleMaxLength(nums01));

        int[] nums1 = new int[] {1,7,4,9,2,5};
        System.out.println(6 == problem.wiggleMaxLength(nums1));

        int[] nums2 = new int[] {1,17,5,10,13,15,10,5,16,8};
        System.out.println(7 == problem.wiggleMaxLength(nums2));

        int[] nums3 = new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println(2 == problem.wiggleMaxLength(nums3));
    }

    // DP
    public int wiggleMaxLength_DP(int[] nums) {
        if( nums.length == 0 ) return 0;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[nums.length-1],up[nums.length-1]);
    }


}
