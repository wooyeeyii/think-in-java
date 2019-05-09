/**
 * 229. Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 *
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem229 {

    // 摩尔投票算法
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] major = new int[2];
        int[] count = new int[] {0, 0};
        for(int i = 0; i < nums.length; i++) {
            if((0 == count[1] || nums[i] != major[1]) && (0 == count[0] || nums[i] == major[0])) {
                major[0] = nums[i];
                count[0]++;
            } else if(0 == count[1] || nums[i] == major[1]) {
                major[1] = nums[i];
                count[1]++;
            } else {
                count[0]--;
                count[1]--;
            }
        }

        // major1 major2 are only candidates, count again;
        for(int j = 0; j < 2; j++) {
            if (count[j] != 0) {
                count[j] = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == major[j]) count[j]++;
                }
            }
            if(count[j] > nums.length / 3) {
                res.add(major[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem229 problem = new Problem229();
        int[] nums1 = new int[] {3,2,3};
        // 3
        System.out.println(ArrayToStringUtil.oneDimension(problem.majorityElement(nums1)));
        System.out.println("#######################");

        int[] nums2 = new int[] {1,1,1,3,3,2,2,2};
        // 1, 2
        System.out.println(ArrayToStringUtil.oneDimension(problem.majorityElement(nums2)));
        System.out.println("#######################");

        int[] nums3 = new int[] {-1,1,1,1,2,1};
        // 1
        System.out.println(ArrayToStringUtil.oneDimension(problem.majorityElement(nums3)));
        System.out.println("#######################");
    }
}
