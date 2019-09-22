package com.chang.leetcode.contest.weekly155;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5199 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean[] used = new boolean[pairs.size()];
        return null;

    }

    // a < b
    private String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, a));
        sb.append(s.charAt(b));
        sb.append(s.substring(a + 1, b));
        sb.append(s.charAt(a));
        sb.append(s.substring((b + 1)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem5199 problem = new Problem5199();
        List<List<Integer>> pairs1 = new ArrayList<>();
        pairs1.add(Arrays.stream(new int[] {0, 3}).boxed().collect(Collectors.toList()));
        pairs1.add(Arrays.stream(new int[] {1, 2}).boxed().collect(Collectors.toList()));
        System.out.println("bacd".equals(problem.smallestStringWithSwaps("dcab", pairs1)));
        pairs1.add(Arrays.stream(new int[] {2, 0}).boxed().collect(Collectors.toList()));
        System.out.println("abcd".equals(problem.smallestStringWithSwaps("dcab", pairs1)));

        List<List<Integer>> pairs2 = new ArrayList<>();
        pairs2.add(Arrays.stream(new int[] {0, 1}).boxed().collect(Collectors.toList()));
        pairs2.add(Arrays.stream(new int[] {1, 2}).boxed().collect(Collectors.toList()));
        System.out.println("abc".equals(problem.smallestStringWithSwaps("cba", pairs2)));

        List<List<Integer>> pairs3 = new ArrayList<>();
        pairs3.add(Arrays.stream(new int[] {3, 3}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[] {3, 0}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[] {5, 1}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[] {3, 1}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[] {3, 4}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[] {3, 5}).boxed().collect(Collectors.toList()));
        System.out.println("deykuy".equals(problem.smallestStringWithSwaps("udyyek", pairs3)));

    }
}
