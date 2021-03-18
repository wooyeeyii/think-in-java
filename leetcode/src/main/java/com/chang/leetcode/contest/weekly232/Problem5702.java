package com.chang.leetcode.contest.weekly232;

public class Problem5702 {

    public int findCenter(int[][] edges) {
        int[] edge1 = edges[0];
        int[] edge2 = edges[1];
        if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
            return edge1[0];
        }

        if (edge1[1] == edge2[0] || edge1[1] == edge2[1]) {
            return edge1[1];
        }

        return -1;
    }

}
