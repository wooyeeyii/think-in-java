package com.chang.leetcode;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem114 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                list.add(p);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }

        for (TreeNode node : list) {
            node.left = null;
            node.right = null;
            if (node == root) {
                p = root;
            } else {
                p.right = node;
                p = node;
            }
        }
    }

    public static void main(String[] args) {
        Problem114 problem = new Problem114();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        problem.flatten(root);
        while (root != null) {
            System.out.printf("%d, ", root.val);
            root = root.right;
        }
    }
}

