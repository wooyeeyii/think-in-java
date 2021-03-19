/*
 * 144 Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 
 * Output: [1,2,3]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
package com.chang.leetcode.tree.traversal;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem144 {
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

    //迭代
    public List<Integer> preorderTraversalIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null != root) {
            stack.push(root);
        }
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // Note that in this solution only right children are stored to stack.
    public List<Integer> preorderTraversalIterImpro(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while (node != null) {
            result.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return result;
    }

}
