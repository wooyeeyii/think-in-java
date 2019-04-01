/**
 * Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
package com.chang.leetcode;

public class Problem42 {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax > rightMax) {
                max += rightMax - height[right];
                right--;
            } else {
                max += leftMax - height[left];
                left ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem42 problem = new Problem42();
        int[] height1 = new int[] {0,0,0,1,0,2,1,0,1,3,2,1,2,1,0,0,0};
        System.out.println(problem.trap(height1));
    }

}
