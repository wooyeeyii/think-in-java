package com.chang.leetcode.contest.weekly169;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem5297 {

    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int element = arr[pos];
            if (0 == element) {
                return true;
            }
            set.add(pos);
            if (pos + element < len && !set.contains(pos + element)) {
                set.add(pos + element);
                queue.add(pos + element);
            }
            if (pos - element >= 0 && !set.contains(pos - element)) {
                set.add(pos - element);
                queue.add(pos - element);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem5297 problem = new Problem5297();
        System.out.println(problem.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(problem.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(!problem.canReach(new int[]{3, 0, 2, 1, 2}, 2));
        System.out.println(problem.canReach(new int[]{0, 3, 0, 6, 3, 3, 4}, 6));
        System.out.println(problem.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(problem.canReach(new int[]{0, 0}, 0));
    }
}
