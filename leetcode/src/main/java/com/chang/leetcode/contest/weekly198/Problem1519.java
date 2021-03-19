/*
 * 1519. Number of Nodes in the Sub-Tree With the Same Label
 *
 * Given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 * The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character
 * given in the string labels (i.e. The node with the number i has the label labels[i]).
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 *
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 *
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 *
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * Output: [2,1,1,1,1,1,1]
 * Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
 * Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
 *
 * Example 2:
 * Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
 * Output: [4,2,1,1]
 * Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
 * The sub-tree of node 3 contains only node 3, so the answer is 1.
 * The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
 * The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.
 *
 * Example 3:
 * Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
 * Output: [3,2,1,1,1]
 *
 * Example 4:
 * Input: n = 6, edges = [[0,1],[0,2],[1,3],[3,4],[4,5]], labels = "cbabaa"
 * Output: [1,2,1,1,2,1]
 *
 * Example 5:
 * Input: n = 7, edges = [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]], labels = "aaabaaa"
 * Output: [6,5,4,1,3,2,1]
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * labels.length == n
 * labels is consisting of only of lower-case English letters.
 *
 */
package com.chang.leetcode.contest.weekly198;

import java.util.*;

public class Problem1519 {

    // TIME LIMIT EXCEED
    public int[] countSubTreesTooSlow(int n, int[][] edges, String labels) {
        int[] parents = new int[n];
        Arrays.fill(parents, -2);
        parents[0] = -1;
        for (int[] link : edges) {
            int a = Math.min(link[0], link[1]);
            int b = Math.max(link[0], link[1]);
            if (parents[b] == -2) {
                parents[b] = a;
            } else {
                parents[a] = b;
            }
        }

        int[] result = new int[n];
        Arrays.fill(result, 0);
        for (int i = 0; i < n; i++) {
            result[i] += 1;
            int par = parents[i];
            while (par != -1) {
                if (labels.charAt(par) == labels.charAt(i)) {
                    result[par] += 1;
                }
                par = parents[par];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1519 problem = new Problem1519();
        int[] rs1 = problem.countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
        int[] rs2 = problem.countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
    }

    public int[] countSubTreesExample1(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        int[] ans = new int[n];
        Set<Integer> seen = new HashSet<>();
        dfs(g, 0, labels, ans, seen);
        return ans;
    }

    private int[] dfs(Map<Integer, List<Integer>> g, int node, String labels, int[] ans, Set<Integer> seen) {
        int[] cnt = new int[26];
        if (seen.add(node)) {
            char c = labels.charAt(node);
            for (int child : g.getOrDefault(node, Collections.emptyList())) {
                int[] sub = dfs(g, child, labels, ans, seen);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
            ++cnt[c - 'a'];
            ans[node] = cnt[c - 'a'];
        }
        return cnt;
    }

    // improve from example1;
    // Since it is a tree, we can avoid duplicate visiting by checking if its neighbor is its parent;
    // Therefore, the following code is simplified by removal of set seen.
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }
        int[] ans = new int[n];
        subCount(map, 0, -1, labels, ans);
        return ans;
    }

    private int[] subCount(Map<Integer, List<Integer>> map, int cur, int parent, String labels, int[] ans) {
        int[] cnt = new int[26];
        char c = labels.charAt(cur);
        for (int child : map.getOrDefault(cur, Collections.emptyList())) {
            if (parent != child) {
                int[] childCnt = subCount(map, child, cur, labels, ans);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += childCnt[i];
                }
            }
        }

        cnt[c - 'a']++;
        ans[cur] = cnt[c - 'a'];
        return cnt;
    }

}
