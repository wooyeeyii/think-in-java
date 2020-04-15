/**
 * 433. Minimum Genetic Mutation
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * <p>
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined
 * as ONE single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end".
 * If there is no such a mutation, return -1.
 * <p>
 * Note:
 * <p>
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * <p>
 * Example 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * return: 1
 * <p>
 * Example 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * return: 2
 * <p>
 * Example 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * return: 3
 */
package com.chang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem433 {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        int count = 0;
        List<String> list = new ArrayList<>();
        boolean containEnd = false;
        for (String b : bank) {
            if (b.equals(end)) {
                containEnd = true;
            }
            list.add(b);
        }
        if (!containEnd) {
            return -1;
        }

        List<String> ori = new ArrayList<>();
        ori.add(start);

        while (list.size() > 0 && ori.size() > 0) {
            List<String> nxt = new ArrayList<>();
            for (String s : ori) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (1 == calDis(s, end)) {
                        return 1 + count;
                    }
                    if (1 == calDis(s, list.get(i))) {
                        nxt.add(list.get(i));
                        list.remove(i);
                    }
                }
            }
            ori = nxt;
            count++;
        }

        return -1;
    }

    private int calDis(String start, String end) {
        if (start.length() != end.length()) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem433 problem = new Problem433();
        String[] bank1 = new String[]{"AACCGGTA"};
        System.out.println(1 == problem.minMutation("AACCGGTT", "AACCGGTA", bank1));

        String[] bank2 = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(2 == problem.minMutation("AACCGGTT", "AAACGGTA", bank2));

        String[] bank3 = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(3 == problem.minMutation("AAAAACCC", "AACCCCCC", bank3));

        String[] bank4 = new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};
        System.out.println(-1 == problem.minMutation("AACCTTGG", "AATTCCGG", bank4));

        String[] bank5 = new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(problem.minMutation("AAAACCCC", "CCCCCCCC", bank5));

        String[] bank6 = new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"};
        System.out.println(-1 == problem.minMutation("AAAAAAAA", "CCCCCCCC", bank6));

    }

}
