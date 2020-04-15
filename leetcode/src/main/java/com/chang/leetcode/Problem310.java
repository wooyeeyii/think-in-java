/**
 * 310. Minimum Height Trees
 * <p>
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees,
 * those with minimum height are called minimum height trees (MHTs). Given such a graph,
 * write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * <p>
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * <p>
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia:
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
package com.chang.leetcode;

import com.chang.common.ArrayToStringUtil;

import java.util.*;

public class Problem310 {

    /**
     * 这个思路实际上是一个 BFS 思路。和常见的从根节点进行 BFS 不同，这里从叶子节点开始进行 BFS。
     *
     * 所有入度（即相连边数）为 1 的节点即是叶子节点。找高度最小的节点，即找离所有叶子节点最远的节点，也即找最中心的节点。
     *
     * 找最中心的节点的思路很简单：
     *
     *     每次去掉当前图的所有叶子节点，重复此操作直到只剩下最后的根。
     *
     *     hint : How many MHTs can a graph have at most
     *     只能有一个或者两个最小高度树树根 (若3个高度相同的子树组成一棵树，可能有3中选择吗？)
     */
    public List<Integer> findMinHeightTreesExample(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        Problem310 problem = new Problem310();
        // 1
        int[][] edges1 = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        System.out.println(ArrayToStringUtil.oneDimension(problem.findMinHeightTrees(4, edges1)));
        System.out.println("################");
        // 3, 4
        int[][] edges2 = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(ArrayToStringUtil.oneDimension(problem.findMinHeightTrees(6, edges2)));
        System.out.println("################");
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] neighbors = new List[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors[i].size() == 1) {
                leaves.add(i);
            }
        }

        int count = n;
        while (count > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            count -= leaves.size();
            for (Integer leave : leaves) {
                Integer node = neighbors[leave].get(0);
                neighbors[node].remove(leave);
                if (neighbors[node].size() == 1) {
                    newLeaves.add(node);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }

}
