/**
 * 228. Summary Ranges
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * <p>
 * Example 2:
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (null == nums || nums.length <= 0) {
            return result;
        }
        int start;
        int i = 0;
        while (i < nums.length) {
            start = nums[i];
            while ((i + 1) < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            int end = i >= nums.length ? nums[nums.length - 1] : nums[i];
            String s = null;
            if (start == end) {
                s = String.valueOf(start);
            } else {
                s = String.valueOf(start) + "->" + String.valueOf(end);
            }
            result.add(s);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem228 problem = new Problem228();
        int[] nums1 = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(ArrayToStringUtil.oneDimension(problem.summaryRanges(nums1)));
        System.out.println("#######################");

        int[] nums2 = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(ArrayToStringUtil.oneDimension(problem.summaryRanges(nums2)));
        System.out.println("#######################");
    }
}
