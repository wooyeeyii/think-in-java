/**
 * 538. Convert BST to Greater Tree
 * <p>
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.Stack;

public class Problem538 {

    // 中序遍历，需要stack协助，那后序遍历呢
    public TreeNode convertBSTSlow(TreeNode root) {
        if (null == root) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        traversalBST(root, stack);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = node.val;
            node.val += sum;
            sum += val;
        }
        return root;
    }

    private void traversalBST(TreeNode node, Stack<TreeNode> stack) {
        if (null != node.left) {
            traversalBST(node.left, stack);
        }
        stack.push(node);
        if (null != node.right) {
            traversalBST(node.right, stack);
        }
    }

    public static void main(String[] args) {
        Problem538 problem = new Problem538();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(13);
        n1.left = n2;
        n1.right = n3;
        TreeNode res1 = problem.convertBST(n1);
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return null;
        }

        postorderTraversal(root);
        return root;
    }

    private void postorderTraversal(TreeNode node) {
        if (null != node.right) {
            postorderTraversal(node.right);
        }
        int pre = node.val;
        node.val += sum;
        sum += pre;
        if (null != node.left) {
            postorderTraversal(node.left);
        }
    }

}
