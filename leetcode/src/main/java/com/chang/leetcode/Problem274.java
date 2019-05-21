package com.chang.leetcode;

public class Problem274 {

    
    public int hIndexExample(int[] citations) {
        int length = 0;
        if (null == citations || 0 == (length = citations.length)) {
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
        int[] data1 = new int[]{0};
        System.out.println(0 == problem.hIndexExample(data1));

        int[] data2 = new int[]{3, 0, 6, 1, 5};
        System.out.println(3 == problem.hIndexExample(data2));

    }

}
