package com.chang.leetcode;

import java.util.*;

public class Problem599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String s : list2) {
            map.put(s, idx);
            idx++;
        }

        for (int i = 0; i < list1.length; i++) {
            if (map.containsKey(list1[i])) {
                if (i + map.get(list1[i]) == min) {
                    res.add(list1[i]);
                } else if (i + map.get(list1[i]) < min) {
                    res.clear();
                    res.add(list1[i]);
                    min = i + map.get(list1[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        Problem599 problem = new Problem599();
        String[] res = problem.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});
    }


}
