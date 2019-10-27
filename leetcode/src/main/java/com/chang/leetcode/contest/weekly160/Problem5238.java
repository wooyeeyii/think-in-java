package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.List;

public class Problem5238 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int max = 1000;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                } else if (customfunction.f(i, j) > z) {
                    break;
                }
            }

            if(customfunction.f(i, 1) > z) {
                break;
            }
        }
        return res;
    }


    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
return 0;
        }
    }
}


