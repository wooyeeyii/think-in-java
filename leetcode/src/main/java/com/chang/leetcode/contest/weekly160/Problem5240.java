package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5240 {

    int max = 0;

    public int maxLength(List<String> arr) {
        int[] flag = new int[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            String s = arr.get(j);
            int a = 0;
            for (int i = 0; i < s.length(); i++) {
                a = a | (1 << (s.charAt(i) - 'a'));
            }
            flag[j] = a;
        }

        boolean[] used = new boolean[arr.size()];
        maxLengthSub(flag, used, 0);

        return max;
    }

    private void maxLengthSub(int[] flag, boolean[] used, int cur) {
        for (int i = 0; i < flag.length; i++) {
            if(used[i]) {
                continue;
            }

            if ((cur & flag[i]) == 0) {
                int next = cur | flag[i];
                max = Math.max(max, getOnes(next));
                used[i] = true;
                maxLengthSub(flag, used, next);
            }
        }
    }

    private int getOnes(int cur) {
        int count = 0;
        while (cur > 0) {
            count += (cur & 1);
            cur = cur >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem5240 problem = new Problem5240();
        String[] arr1 = new String[]{"un", "iq", "ue"};
        List<String> list1 = Arrays.asList(arr1);
        System.out.println(4 == problem.maxLength(list1));

        String[] arr2 = new String[]{"cha", "r", "act", "ers"};
        List<String> list2 = Arrays.asList(arr2);
        System.out.println(6 == problem.maxLength(list2));

        String[] arr4 = new String[]{"a","b","c","d","e","f","g","h", "i", "j", "k"};
        List<String> list4 = Arrays.asList(arr4);
        System.out.println(11 == problem.maxLength(list4));

        String[] arr3 = new String[]{"abcdefghijklmnopqrstuvwxyz"};
        List<String> list3 = Arrays.asList(arr3);
        System.out.println(26 == problem.maxLength(list3));


    }

}


