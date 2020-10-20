package com.chang.leetcode.contest.weekly206;

import java.util.*;

public class Problem1584 {

    class IdxDis {
        public int idx;
        private int dis;

        public IdxDis(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        if (1 == points.length) {
            return 0;
        }

        int min = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<IdxDis>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;

                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                List<IdxDis> l = map.getOrDefault(i, new ArrayList<>());
                l.add(new IdxDis(j, dis));
                map.put(i, l);
            }
            map.get(i).sort((a, b) -> a.dis - b.dis);
        }

        List<IdxDis> list = map.get(0);
        set.add(0);
        while (list.size() > 0) {
            min += list.get(0).dis;
            set.add(list.get(0).idx);
            list = merge(map, set, list);
        }

        return min;
    }

    private List<IdxDis> merge(Map<Integer, List<IdxDis>> map, Set<Integer> setAlready, List<IdxDis> list) {
        Set<Integer> set = new HashSet<>(setAlready);
        List<IdxDis> resL = new ArrayList<>();
        List<IdxDis> newL = map.get(list.get(0).idx);
        int i = 0, j = 0;
        while (i < newL.size() && j < list.size()) {
            if (set.contains(newL.get(i).idx)) {
                i++;
                continue;
            }
            if (set.contains(list.get(j).idx)) {
                j++;
                continue;
            }

            if (newL.get(i).dis < list.get(j).dis) {
                resL.add(newL.get(i));
                set.add(newL.get(i).idx);
                i++;
            } else {
                resL.add(list.get(j));
                set.add(list.get(j).idx);
                j++;
            }
        }

        while (i < newL.size()) {
            if (!set.contains(newL.get(i).idx)) {
                resL.add(newL.get(i));
                set.add(newL.get(i).idx);
            }
            i++;
        }
        while (j < list.size()) {
            if (!set.contains(list.get(j).idx)) {
                resL.add(list.get(j));
                set.add(list.get(j).idx);
            }
            j++;
        }

        return resL;
    }

    public static void main(String[] args) {
        Problem1584 problem = new Problem1584();
        System.out.println(problem.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(problem.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(problem.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(problem.minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println(problem.minCostConnectPoints(new int[][]{{0, 0}}));
    }

}
