package com.chang.leetcode;

import com.chang.common.MapUtil;

import java.util.HashMap;
import java.util.Map;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 != length2) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < length1; i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(s.charAt(i), MapUtil.getOrDefault(map, s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length2; i++) {
//            int value = map.getOrDefault(t.charAt(i), 0) - 1;
            int value = MapUtil.getOrDefault(map, (t.charAt(i)), 0) - 1;
            if (value < 0) {
                return false;
            }
            map.put(t.charAt(i), value);
        }

        return true;
    }

    public static void main(String[] args) {
        Problem242 problem = new Problem242();
        System.out.println(problem.isAnagram("anagram", "nagaram"));
        System.out.println(problem.isAnagram("rat", "car"));
        System.out.println(problem.isAnagram("我", "你"));
        System.out.println(problem.isAnagram("aacc", "ccac"));
    }
}
