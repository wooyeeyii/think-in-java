package com.chang.leetcode.contest.weekly231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1786 {

    public int countRestrictedPaths(int n, int[][] edges) {
        if (n == 1) return 0;
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[2], e[1]});
            graph[e[1]].add(new int[]{e[2], e[0]});
        }
        int[] dist = dijkstra(n, graph);
        return dfs(1, n, graph, dist, new Integer[n + 1]);
    }

    // Dijkstra to find shortest distance of paths from node `n` to any other nodes
    int[] dijkstra(int n, List<int[]>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // dist, node
        minHeap.offer(new int[]{0, n});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], u = top[1];
            if (d != dist[u]) continue;
            for (int[] nei : graph[u]) {
                int w = nei[0], v = nei[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    minHeap.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }

    int dfs(int src, int n, List<int[]>[] graph, int[] dist, Integer[] memo) {
        if (memo[src] != null) return memo[src];
        if (src == n) return 1; // Found a path to reach to destination
        int ans = 0;
        for (int[] nei : graph[src]) {
            int w = nei[0], v = nei[1];
            if (dist[src] > dist[v])
                ans = (ans + dfs(v, n, graph, dist, memo)) % 1000000007;
        }
        return memo[src] = ans;
    }

}
