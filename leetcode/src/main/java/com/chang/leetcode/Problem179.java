/*
 * 179. Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
package com.chang.leetcode;

import java.util.Arrays;

public class Problem179 {

    public String largestNumber(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (compare(nums[j], nums[j + 1]) < 0) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private int compare(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int len1 = aStr.length();
        int len2 = bStr.length();
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            if (aStr.charAt(i) > bStr.charAt(i)) {
                return 1;
            } else if (aStr.charAt(i) < bStr.charAt(i)) {
                return -1;
            }
        }

        String res1 = aStr + bStr;
        String res2 = bStr + aStr;

        return res1.compareTo(res2);
    }

    public static void main(String[] args) {
        Problem179 problem = new Problem179();
        int[] nums1 = new int[]{10, 2};
        System.out.println("210".equals(problem.largestNumber(nums1)));
        int[] nums2 = new int[]{3, 30, 34, 5, 9};
        System.out.println("9534330".equals(problem.largestNumber(nums2)));

        // 看这里
        int[] nums3 = new int[]{121, 12};
        System.out.println("12121".equals(problem.largestNumber(nums3)));

        int[] nums4 = new int[]{12, 128};
        System.out.println((problem.largestNumber(nums4)));
    }

    public String largestNumberExample(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
