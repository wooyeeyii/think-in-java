package com.chang.leetcode.contest.weekly160;

import java.util.ArrayList;
import java.util.List;

public class Problem5239 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 1; i <= n; i++) {
            List<Integer> newL = new ArrayList<>();
            for(int j = list.size() - 1; j >= 0; j--) {
                newL.add((list.get(j) << 1) + 1);
                list.set(j, list.get(j) << 1);
            }
            list.addAll(newL);
        }

        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == start) {
                idx = i;
                break;
            }
        }
        for(int i = idx; i < list.size(); i++) {
            res.add(list.get(i));
        }
        for(int i = 0; i < idx; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Problem5239 problem = new Problem5239();
        // [3,2,0,1] or [3,1,0,2]
        List<Integer> res1 = problem.circularPermutation(2, 3);
        // [2,6,7,5,4,0,1,3]
        List<Integer> res2 = problem.circularPermutation(3, 2);
    }

}


