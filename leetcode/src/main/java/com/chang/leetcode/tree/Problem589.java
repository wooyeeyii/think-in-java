/**
 * 589. N-ary Tree Preorder Traversal
 *
 *  Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 *      1
 *    / | \
 *   3  2  4
 *  /\
 * 5 6
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
package com.chang.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem589 {

    // Recursive
    public List<Integer> preorderRec(Node root) {
        List<Integer> result = new ArrayList<>();

        if(null == root) {
            return result;
        }

        result.add(root.val);
        root.children.forEach(node -> {
            result.addAll(preorderRec(node));
        });

        return result;
    }

    // iteratively
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(null == root) {
            return result;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();
            result.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--) {
                deque.addFirst(node.children.get(i));
            }
        }
        return result;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
