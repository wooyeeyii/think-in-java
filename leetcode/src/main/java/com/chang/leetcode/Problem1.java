package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int start = 0, end = 0;
        int maxLength = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (s.length() <= 0) {
            return 0;
        }
        while (i < s.length()) {
            String cur = String.valueOf(s.charAt(i));
            if (map.containsKey(cur)) {
                if (maxLength < (i - map.get(cur))) {
                    start = map.get(cur);
                    end = i - 1;
                    maxLength = end - start + 1;
                }
            }
            map.put(cur, i);
            i++;
        }
        if (maxLength < (s.length() - start)) {
            maxLength = s.length() - start;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem1 problem = new Problem1();
        //String s = "mvxeatytrillkbtpvlofyaetzwyttlofiljk";
        String s = "abcabcbb";
        int res = problem.lengthOfLongestSubstring(s);
        System.out.println(res);
        //System.out.println(s.substring(0, 2));

    }

}
