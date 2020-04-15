package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums) {
            if (1 == map.get(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * int数是一个32bit的数，依次统计每个bit出现的次数，若%3 == 0
     * 则这个bit的数字出现了三次(或几个不同的数字各出现了三次)
     * 若%3 != 0， 则改位为1
     */
    public int singleNumberSample(int[] nums) {
        int result = 0;
        int repeatCount = 3;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                if (0 != (num & 1 << i)) {
                    bitCount++;
                }
            }
            if (bitCount % repeatCount != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem137 problem = new Problem137();
        int[] nums1 = new int[]{2, 2, 3, 2};
        System.out.println(3 == problem.singleNumber(nums1));
        int[] nums2 = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(99 == problem.singleNumber(nums2));
        int[] nums3 = new int[]{-19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28};
        System.out.println(-28 == problem.singleNumber(nums3));
    }
}
