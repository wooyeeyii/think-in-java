/*
 * 138. Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * Example 1:
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
package com.chang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {

    /*
     * 使用O(n)的时间，因利用HashMap的原因，O(n)的空间
     * 可以更进一步，使用O(1)的空间？
     */
    public NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {
        Map<NodeWithRandomPointer, NodeWithRandomPointer> nMap = new HashMap<>();
        NodeWithRandomPointer ori = head;
        while (null != ori) {
            NodeWithRandomPointer copy = new NodeWithRandomPointer(ori.val, null, null);
            nMap.put(ori, copy);
            ori = ori.next;
        }

        ori = head;
        while (null != ori) {
            nMap.get(ori).next = nMap.get(ori.next);
            nMap.get(ori).random = (ori.random == null ? null : nMap.get(ori.random));
            ori = ori.next;
        }

        return nMap.get(head);
    }

    /*
     * 使用O(1) space
     */
    public NodeWithRandomPointer copyRandomListUseConstantSpace(NodeWithRandomPointer head) {
        NodeWithRandomPointer ori = head;
        while (null != ori) {
            NodeWithRandomPointer copy = new NodeWithRandomPointer(ori.val, ori.next, null);
            ori.next = copy;
            ori = copy.next;
        }

        ori = head;
        while (ori != null) {
            if (ori.random != null) {
                ori.next.random = ori.random.next;
            }
            ori = ori.next.next;
        }

        ori = head;
        NodeWithRandomPointer newHead = (null == ori ? null : ori.next);
        while (ori != null) {
            NodeWithRandomPointer tmp = ori.next;
            ori.next = tmp.next;
            ori = ori.next;
            if (null != ori) {
                tmp.next = ori.next;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        Problem138 problem = new Problem138();
        NodeWithRandomPointer n1 = new NodeWithRandomPointer(1, null, null);
        NodeWithRandomPointer n2 = new NodeWithRandomPointer(2, null, null);
        n1.next = n2;
        n2.random = n2;
        NodeWithRandomPointer res = problem.copyRandomListUseConstantSpace(null);
        System.out.println(res);
    }


}

class NodeWithRandomPointer {
    public int val;
    public NodeWithRandomPointer next;
    public NodeWithRandomPointer random;

    public NodeWithRandomPointer() {
    }

    public NodeWithRandomPointer(int _val, NodeWithRandomPointer _next, NodeWithRandomPointer _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
