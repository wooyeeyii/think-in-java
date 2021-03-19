/*
 * 1257. Smallest Common Region
 *
 * You are given some lists of regions where the first region of each list includes all other regions in that list.
 * Naturally, if a region X contains another region Y then X is bigger than Y.
 * Given two regions region1, region2, find out the smallest region that contains both of them.
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.
 * It's guaranteed the smallest region exists.
 *
 * Example 1:
 * Input:
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * Output: "North America"
 *
 * Constraints:
 *
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * All strings consist of English letters and spaces with at most 20 letters.
 */
package com.chang.leetcode.contest.biweekly13;

import java.util.*;

public class Problem1257 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();

        for (List<String> list : regions) {
            String big = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                map.put(list.get(i), big);
            }
        }

        if (!map.containsKey(region1)) {
            return region1;
        }
        if (!map.containsKey(region2)) {
            return region2;
        }

        List<String> list1 = new ArrayList<>();
        String s = region1;
        list1.add(s);
        while (map.containsKey(s)) {
            s = map.get(s);
            list1.add(s);
        }

        s = region2;
        List<String> list2 = new ArrayList<>();
        list2.add(s);
        while (map.containsKey(s)) {
            s = map.get(s);
            list2.add(s);
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    return list1.get(i);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Problem1257 problem = new Problem1257();
        List<List<String>> regions1 = new ArrayList<>();
        regions1.add(new ArrayList<>(Arrays.asList(new String[]{"Earth", "North America", "South America"})));
        regions1.add(new ArrayList<>(Arrays.asList(new String[]{"North America", "United States", "Canada"})));
        regions1.add(new ArrayList<>(Arrays.asList(new String[]{"United States", "New York", "Boston"})));
        regions1.add(new ArrayList<>(Arrays.asList(new String[]{"Canada", "Ontario", "Quebec"})));
        regions1.add(new ArrayList<>(Arrays.asList(new String[]{"South America", "Brazil"})));
        System.out.println("Earth".equals(problem.findSmallestRegion(regions1, "Canada", "South America")));
    }


}
