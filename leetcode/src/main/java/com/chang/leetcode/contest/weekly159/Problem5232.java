package com.chang.leetcode.contest.weekly159;

import java.util.HashMap;
import java.util.Map;

public class Problem5232 {

    public int balancedString(String s) {
        int len = s.length();
        int same = len / 4;
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        int left = 0;
        int i = 0;
        for(; i < s.length(); i++) {
            Character c = s.charAt(i);
            int m = map.get(c);
            if(m + 1 > same) {
                break;
            }
            map.put(c, m + 1);
        }
        if(i == len) return 0;
        left = i;

        int max = left;
        int right = len - 1;
        while(left >= 0) {
            while(right > left) {
                Character c2 = s.charAt(right);
                if(map.get(c2) == same) {
                    break;
                } else {
                    map.put(c2, map.get(c2) + 1);
                    right--;
                }
            }
            max = Math.max(max, left - 1 + len - right);

            if(left <= 0) break;
            Character c1 = s.charAt(left - 1);
            map.put(c1, map.get(c1) - 1);
            left--;
        }
        return len - max;
    }

    public static void main(String[] args) {
        Problem5232 problem = new Problem5232();
        System.out.println(0 == problem.balancedString("QWER"));
        System.out.println(1 == problem.balancedString("QQWE"));
        System.out.println(2 == problem.balancedString("QQQW"));
        System.out.println(3 == problem.balancedString("QQQQ"));
        System.out.println(5 == problem.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
    }
}
