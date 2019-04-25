package com.chang.leetcode;

public class Problem165 {

    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        int len1 = list1.length;
        int len2 = list2.length;
        int len = Math.min(len1, len2);
        for(int i = 0; i < len; i++) {
            if(Integer.parseInt(list1[i]) > Integer.parseInt(list2[i])) {
                return 1;
            } else if(Integer.parseInt(list1[i]) < Integer.parseInt(list2[i])) {
                return -1;
            }
        }

        for(int j = len; j < len1; j++) {
            if(0 != Integer.parseInt(list1[j])) {
                return 1;
            }
        }
        for(int j = len; j < len2; j++) {
            if(0 != Integer.parseInt(list2[j])) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem165 problem = new Problem165();
        System.out.println(-1 == problem.compareVersion("0.1", "1.1"));
        System.out.println(1 == problem.compareVersion("1.0.1", "1"));
        System.out.println(-1 == problem.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(0 == problem.compareVersion("1.01", "1.001"));
        System.out.println(0 == problem.compareVersion("1.0", "1.0.0"));
    }

}
