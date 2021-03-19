/*
 * 1514. Path with Maximum Probability
 *
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b]
 * is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 *
 * Example 1:
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 *
 * Example 2:
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * Output: 0.30000
 *
 * Example 3:
 * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * Output: 0.00000
 * Explanation: There is no path between 0 and 2.
 *
 * Constraints:
 * 2 <= n <= 10^4
 * 0 <= start, end < n
 * start != end
 * 0 <= a, b < n
 * a != b
 * 0 <= succProb.length == edges.length <= 2*10^4
 * 0 <= succProb[i] <= 1
 * There is at most one edge between every two nodes.
 *
 */
package com.chang.leetcode.contest.weekly197;

import java.util.*;

public class Problem1514 {

    private boolean reached = false;
    private double result = 0;

    // TOO SLOW
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Values>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] pair = edges[i];
            List<Values> l = map.getOrDefault(pair[0], new ArrayList<>());
            l.add(new Values(pair[1], succProb[i]));
            map.put(pair[0], l);

            List<Values> l2 = map.getOrDefault(pair[1], new ArrayList<>());
            l2.add(new Values(pair[0], succProb[i]));
            map.put(pair[1], l2);
        }

        divMaxProbability(map, start, end, new HashSet<>(), 1);

        return reached ? result : 0;
    }

    private void divMaxProbability(Map<Integer, List<Values>> map, int start, int end, Set<Integer> set, double p) {
        if (start == end) {
            result = Math.max(result, p);
            reached = true;
        }

        List<Values> values = map.getOrDefault(start, new ArrayList<>());
        for (Values v : values) {
            if (!set.contains(v.node)) {
                set.add(v.node);
                divMaxProbability(map, v.node, end, set, p * v.prob);
                set.remove(v.node);
            }
        }
    }

    class Values {
        public int node;
        public double prob;

        public Values(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        Problem1514 problem = new Problem1514();
        System.out.println(problem.maxProbability2(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        problem.reached = false;
        problem.result = 0;
        System.out.println(problem.maxProbability2(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.3}, 0, 2));
        problem.reached = false;
        problem.result = 0;
        System.out.println(problem.maxProbability2(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }

    public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Values>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] pair = edges[i];
            List<Values> l = map.getOrDefault(pair[0], new ArrayList<>());
            l.add(new Values(pair[1], succProb[i]));
            map.put(pair[0], l);

            List<Values> l2 = map.getOrDefault(pair[1], new ArrayList<>());
            l2.add(new Values(pair[0], succProb[i]));
            map.put(pair[1], l2);
        }

        Map<Integer, Double> res = new HashMap<>();
        PriorityQueue<Values> priorityQueue = new PriorityQueue<>((v1, v2) ->
                v1.prob - v2.prob < 0 ? 1 : ((v1.prob - v2.prob > 0) ? -1 : 0)
        );

        priorityQueue.add(new Values(start, 1));
        while (!priorityQueue.isEmpty()) {
            Values cur = priorityQueue.poll();
            if (res.containsKey(cur.node)) continue;
            res.put(cur.node, cur.prob);
            if (map.containsKey(cur.node)) {
                for (Values edge : map.get(cur.node)) {
                    if (!res.containsKey(edge.node)) {
                        priorityQueue.offer(new Values(edge.node, edge.prob * cur.prob));
                    }
                }
            }
        }

        return res.getOrDefault(end, 0D);
    }

    // 2为计算全部其他节点，只为计算到end就好了
    public double maxProbability3(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Values>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] pair = edges[i];
            List<Values> l = map.getOrDefault(pair[0], new ArrayList<>());
            l.add(new Values(pair[1], succProb[i]));
            map.put(pair[0], l);

            List<Values> l2 = map.getOrDefault(pair[1], new ArrayList<>());
            l2.add(new Values(pair[0], succProb[i]));
            map.put(pair[1], l2);
        }

        Map<Integer, Double> res = new HashMap<>();
        PriorityQueue<Values> priorityQueue = new PriorityQueue<>((v1, v2) ->
                Double.compare(v2.prob, v1.prob)
        );

        priorityQueue.add(new Values(start, 1));
        while (!priorityQueue.isEmpty()) {
            Values cur = priorityQueue.poll();
            if (res.containsKey(cur.node)) continue;
            if (end == cur.node) {
                return cur.prob;
            }
            res.put(cur.node, cur.prob);
            if (map.containsKey(cur.node)) {
                for (Values edge : map.get(cur.node)) {
                    if (!res.containsKey(edge.node)) {
                        priorityQueue.offer(new Values(edge.node, edge.prob * cur.prob));
                    }
                }
            }
        }

        return 0.0;
    }


}
