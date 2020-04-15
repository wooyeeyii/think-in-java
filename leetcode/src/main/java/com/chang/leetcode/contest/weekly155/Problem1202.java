/**
 * 1202. Smallest String With Swaps
 * <p>
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 * <p>
 * Example 1:
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * <p>
 * Example 2:
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * <p>
 * Example 3:
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
package com.chang.leetcode.contest.weekly155;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        int[] uf = new int[len];
        for (int i = 0; i < len; i++) {
            uf[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int root0 = findRoot(uf, pair.get(0));
            int root1 = findRoot(uf, pair.get(1));

            if (root0 != root1) {
                uf[root0] = root1;
            }
        }

        List<Integer>[] group = new List[len];
        for (int i = 0; i < s.length(); i++) {
            int root = findRoot(uf, i);
            if (group[root] == null) group[root] = new ArrayList<>();
            group[root].add(i);
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (group[i] != null && group[i].size() > 0) {
                int size = group[i].size();
                char[] arr2 = new char[size];
                for (int j = 0; j < size; j++) arr2[j] = arr[group[i].get(j)];
                Arrays.sort(arr2);// sort to smallest
                for (int j = 0; j < size; j++) arr[group[i].get(j)] = arr2[j];
            }
        }
        return new String(arr);
    }

    private int findRoot(int[] uf, int x) {
        while (x != uf[x]) {
            x = uf[x];
        }
        return x;
    }

    public static void main(String[] args) {
        Problem1202 problem = new Problem1202();
        List<List<Integer>> pairs1 = new ArrayList<>();
        pairs1.add(Arrays.stream(new int[]{0, 3}).boxed().collect(Collectors.toList()));
        pairs1.add(Arrays.stream(new int[]{1, 2}).boxed().collect(Collectors.toList()));
        System.out.println("bacd".equals(problem.smallestStringWithSwaps("dcab", pairs1)));
        pairs1.add(Arrays.stream(new int[]{2, 0}).boxed().collect(Collectors.toList()));
        System.out.println("abcd".equals(problem.smallestStringWithSwaps("dcab", pairs1)));

        List<List<Integer>> pairs2 = new ArrayList<>();
        pairs2.add(Arrays.stream(new int[]{0, 1}).boxed().collect(Collectors.toList()));
        pairs2.add(Arrays.stream(new int[]{1, 2}).boxed().collect(Collectors.toList()));
        System.out.println("abc".equals(problem.smallestStringWithSwaps("cba", pairs2)));

        List<List<Integer>> pairs3 = new ArrayList<>();
        pairs3.add(Arrays.stream(new int[]{3, 3}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{3, 0}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{5, 1}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{3, 1}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{3, 4}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{3, 5}).boxed().collect(Collectors.toList()));
        pairs3.add(Arrays.stream(new int[]{3, 0}).boxed().collect(Collectors.toList()));
        System.out.println("deykuy".equals(problem.smallestStringWithSwaps("udyyek", pairs3)));

    }

    // UF
    public String smallestStringWithSwapsExample(String s, List<List<Integer>> swaps) {
        int N = s.length();

        UnionFind uf = new UnionFind(N);
        for (List<Integer> swap : swaps) {
            uf.union(swap.get(0), swap.get(1));
        }

        Map<Integer, List<Character>> graphs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int head = uf.find(i);
            List<Character> characters = graphs.computeIfAbsent(head, (dummy) -> new ArrayList<>());
            characters.add(s.charAt(i));
        }

        for (List<Character> characters : graphs.values()) {
            Collections.sort(characters);
        }

        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            List<Character> characters = graphs.get(uf.find(i));
            char currentMin = characters.remove(0);
            sb.append(currentMin);
        }
        return sb.toString();
    }

    private class UnionFind {
        public int[] size;
        public int[] parent;

        UnionFind(int count) {
            size = new int[count];
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        int union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return size[pRoot];
            }
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
                return size[pRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                return size[qRoot];
            }

        }
    }


    // example2
    public String smallestStringWithSwapsExample2(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] p = new int[n];
        List<Integer>[] group = new List[n];
        for (int i = 0; i < n; i++) p[i] = i;

        // union index group
        for (List<Integer> pair : pairs) {
            int x = pair.get(0), y = pair.get(1);
            int pX = find(p, x), pY = find(p, y);
            if (pX != pY) p[pX] = pY;
        }

        // add same root to one group
        for (int i = 0; i < s.length(); i++) {
            int root = find(p, i);
            if (group[root] == null) group[root] = new ArrayList<>();
            group[root].add(i);
        }

        // get connected group and rearrange order in s
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (group[i] != null && group[i].size() > 0) {
                int size = group[i].size();
                char[] arr2 = new char[size];
                for (int j = 0; j < size; j++) arr2[j] = arr[group[i].get(j)];
                Arrays.sort(arr2);// sort to smallest
                for (int j = 0; j < size; j++) arr[group[i].get(j)] = arr2[j];
            }
        }
        return new String(arr);
    }

    public int find(int[] p, int x) {
        if (p[x] == x) return x;
        p[x] = find(p, p[x]);
        return p[x];
    }

}


