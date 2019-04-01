package com.chang.leetcode;

import java.util.Arrays;

public class Problem274 {
    
    public int hIndex(int[] citations) {
        if (citations.length <=0 ) {
            return 0;
        }
        
        Arrays.sort(citations);
        int max = 1;
        for (int i = 0; i < citations.length; i++) {
            if (i <= citations.length - i) {
                max = i + 1;
            }
        }
        return max;
    }
    
    public int hIndex2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Problem274 problem = new Problem274();
//        int[] data = new int[]{3, 0, 6, 1, 5};
        int[] data = new int[]{0};
        System.out.println(problem.hIndex2(data));
    }

}
