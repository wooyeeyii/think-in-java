/**
 * 1282. Group the People Given the Group Size They Belong To
 * <p>
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
 * Given the array groupSizes of length n telling the group size each person belongs to,
 * return the groups there are and the people's IDs each group includes.
 * <p>
 * You can return any solution in any order and the same applies for IDs.
 * Also, it is guaranteed that there exists at least one solution.
 * <p>
 * Example 1:
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 * Explanation:
 * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 * <p>
 * Example 2:
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1],[0,5],[2,3,4]]
 * <p>
 * Constraints:
 * <p>
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 */
package com.chang.leetcode.contest.weekly166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = map.getOrDefault(groupSizes[i], new ArrayList<>());
            tmp.add(i);
            map.put(groupSizes[i], tmp);
        }

        List<List<Integer>> list = new ArrayList<>();
        map.forEach((k, v) -> {
            List<Integer> subList = null;
            for (int i = 0; i < v.size(); i++) {
                if (i % k == 0) {
                    if (null != subList) {
                        list.add(new ArrayList<>(subList));
                    }
                    subList = new ArrayList();
                }
                subList.add(v.get(i));
            }
            if (null != subList) {
                list.add(new ArrayList<>(subList));
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Problem1282 problem = new Problem1282();
        List<List<Integer>> list = problem.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
    }


}
