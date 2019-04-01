package com.chang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strArray[i])) {
                    return false;
                }
            } else {
                if(!set.add(strArray[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strArray[i]);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Problem290 problem = new Problem290();
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(problem.wordPattern(pattern, str));
    }
}
