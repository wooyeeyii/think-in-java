package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.List;

public class Problem1239OfMy implements Interface1239 {

    int max = 0;

    // Time Limit Exceeded
    @Override
    public int maxLength(List<String> arr) {

        int[] flag = getIntegerFromString(arr);

        maxLengthSub(flag, 0, 0);

        return max;
    }

    private void maxLengthSub(int[] flag, int cur, int idx) {
        for (int i = idx; i < flag.length; i++) {
            if ((cur & flag[i]) == 0) {
                int next = cur | flag[i];
                max = Math.max(max, Integer.bitCount(next));
                maxLengthSub(flag, next, i + 1);
            }
        }
    }

    // 这里很慢
    /*private int[] getIntegerFromString(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
            String s = arr.get(j);
            int a = 0;
            boolean valid = true;
            for (int i = 0; i < s.length(); i++) {
                if (1 == ((a >> (s.charAt(i) - 'a')) & 1)) {
                    valid = false;
                    break;
                }
                a = a | (1 << (s.charAt(i) - 'a'));
            }
            if (valid) {
                list.add(a);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }*/

    private int[] getIntegerFromString(List<String> arr) {
        int[] bitmapArr = new int[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            int a = uniqueCharsToInt(arr.get(j));
            if(a != 0) {
                bitmapArr[j] = a;
            }
        }

        return bitmapArr;
    }

    public int uniqueCharsToInt(String str) {
        int b = 0;
        if (str == null) return b;

        for (int i = 0; i < str.length(); i++) {
            if ((b & 1 << str.charAt(i) - 'a') == 0) {
                b |= 1 << str.charAt(i) - 'a';
            } else {
                return 0;
            }
        }
        return b;
    }

}
