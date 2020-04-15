/**
 * 406. Queue Reconstruction by Height
 * <p>
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people
 * in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
package com.chang.leetcode;

import java.util.*;

public class Problem406 {

    public int[][] reconstructQueueSlow(int[][] people) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[people.length];
        for (int i = 0; i < people.length; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(people[i][0]);
            row.add(people[i][1]);
            list.add(row);
        }
        list.sort((a, b) -> {
            return a.get(0) - b.get(0);
        });

        list.forEach(l -> {
            int pos = l.get(1);
            int i = 0;
            while (pos > 0 || used[i]) {
                if (!used[i] || people[i][0] >= l.get(0)) {
                    pos--;
                }
                i++;
            }

            people[i][0] = l.get(0);
            people[i][1] = l.get(1);
            used[i] = true;
        });

        return people;
    }

    public static void main(String[] args) {
        Problem406 problem = new Problem406();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = problem.reconstructQueue(people);
        System.out.println("############");
    }


    // 1. Pick out tallest group of people and sort them in a subarray (S).
    //          Since there's no other groups of people taller than them,
    //          therefore each guy's index will be just as same as his k value.
    // 2. For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.

    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

}
