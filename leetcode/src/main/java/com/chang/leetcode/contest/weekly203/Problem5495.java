package com.chang.leetcode.contest.weekly203;

import java.util.ArrayList;
import java.util.List;

public class Problem5495 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int len = rounds.length;
        int begin = rounds[0], end = rounds[len - 1];
        if (end >= begin) {
            for (int i = begin; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = begin; i <= n; i++) {
                res.add(i);
            }
        }
        return res;
    }

}
