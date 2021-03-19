/*
 * 589. N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 * 1
 * / | \
 * 3  2  4
 * /\
 * 5 6
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 */
package com.chang.leetcode.tree;

import java.util.*;

public class Problem590 {

    // Recursive
    public List<Integer> postorderRec(Node root) {
        List<Integer> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        root.children.forEach(node -> {
            result.addAll(postorderRec(node));
        });
        result.add(root.val);

        return result;
    }

    // iteratively
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (null == node.children || 0 == node.children.size()) {
                result.add(node.val);
            } else {
                List<Node> children = node.children;
                node.children = null;
                stack.push(node);
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem590 problem = new Problem590();
        Node n1 = problem.new Node(1, new ArrayList<>());
        Node n2 = problem.new Node(2, new ArrayList<>());
        Node n3 = problem.new Node(3, new ArrayList<>());
        Node n4 = problem.new Node(4, new ArrayList<>());
        Node n5 = problem.new Node(5, new ArrayList<>());
        Node n6 = problem.new Node(6, new ArrayList<>());
        List<Node> children1 = new ArrayList<>();
        children1.add(n3);
        children1.add(n2);
        children1.add(n4);
        n1.children = children1;
        List<Node> children2 = new ArrayList<>();
        children2.add(n5);
        children2.add(n6);
        n3.children = children2;
        List<Integer> res1 = problem.postorder(n1);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
