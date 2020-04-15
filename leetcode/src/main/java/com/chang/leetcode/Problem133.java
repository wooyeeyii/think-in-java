/**
 * 133. Clone Graph
 * <p>
 * Given a reference of a node in a connected undirected graph,
 * return a deep copy (clone) of the graph. Each node in the graph contains a val (int)
 * and a list (List[Node]) of its neighbors.
 * <p>
 * Example:
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * <p>
 * Note:
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor,
 * then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
package com.chang.leetcode;

import java.util.*;

public class Problem133 {

    public NodeWithNeighbors cloneGraph(NodeWithNeighbors node) {
        Map<NodeWithNeighbors, NodeWithNeighbors> map = new HashMap<>();
        Queue<NodeWithNeighbors> queue = new LinkedList<>();
        if (null == node) {
            return null;
        }
        NodeWithNeighbors m1 = new NodeWithNeighbors(node.val, null);
        queue.add(node);
        map.put(node, m1);
        while (queue.size() > 0) {
            NodeWithNeighbors n = queue.poll();
            n.neighbors.forEach(no -> {
                if (!map.containsKey(no)) {
                    NodeWithNeighbors m = new NodeWithNeighbors(no.val, null);
                    map.put(no, m);
                    queue.add(no);
                }
            });
        }
        for (Map.Entry<NodeWithNeighbors, NodeWithNeighbors> entry : map.entrySet()) {
            List<NodeWithNeighbors> l = new ArrayList<>();
            entry.getKey().neighbors.forEach(n -> {
                l.add(map.get(n));
            });
            entry.getValue().neighbors = l;
        }
        return m1;
    }


    Map<NodeWithNeighbors, NodeWithNeighbors> nodeMap = new HashMap<>();

    public NodeWithNeighbors cloneGraphNew(NodeWithNeighbors ori) {
        if (nodeMap.containsKey(ori)) {
            return nodeMap.get(ori);
        }
        NodeWithNeighbors copy = new NodeWithNeighbors(ori.val, new ArrayList<>());
        nodeMap.put(ori, copy);
        ori.neighbors.forEach(n -> {
            copy.neighbors.add(cloneGraphNew(n));
        });
        return copy;
    }

    public static void main(String[] args) {
        Problem133 problem = new Problem133();
        NodeWithNeighbors n1 = new NodeWithNeighbors(1, null);
        NodeWithNeighbors n2 = new NodeWithNeighbors(2, null);
        NodeWithNeighbors n3 = new NodeWithNeighbors(3, null);
        NodeWithNeighbors n4 = new NodeWithNeighbors(4, null);
        List<NodeWithNeighbors> l1 = new ArrayList<>();
        l1.add(n2);
        l1.add(n4);
        n1.neighbors = l1;
        List<NodeWithNeighbors> l2 = new ArrayList<>();
        l2.add(n1);
        l2.add(n3);
        n2.neighbors = l2;
        List<NodeWithNeighbors> l3 = new ArrayList<>();
        l3.add(n2);
        l3.add(n4);
        n3.neighbors = l3;
        List<NodeWithNeighbors> l4 = new ArrayList<>();
        l4.add(n3);
        l4.add(n1);
        n4.neighbors = l4;
        NodeWithNeighbors res = problem.cloneGraphNew(n1);
        System.out.println(res);
    }

}

class NodeWithNeighbors {
    public int val;
    public List<NodeWithNeighbors> neighbors;

    public NodeWithNeighbors() {
    }

    public NodeWithNeighbors(int _val, List<NodeWithNeighbors> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

