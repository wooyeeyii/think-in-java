/*
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * 2
 * / \
 * 1   3
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem98 {

    // slow
    public boolean isValidBSTSlow(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        middleSearchTree(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void middleSearchTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        middleSearchTree(root.left, list);
        list.add(root.val);
        middleSearchTree(root.right, list);
    }


    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isValidBST(root.left) && (prev == null || root.val > prev.val)) {
            prev = root;
            return isValidBST(root.right);
        }

        return false;
    }

    public boolean isValidBST_2(TreeNode root) {
        Integer pre = null;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || null != p) {
            if (null != p) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode end = stack.pop();
                if (null == pre) {
                    pre = end.val;
                } else {
                    if (pre >= end.val) {
                        return false;
                    }
                    pre = end.val;
                }
                p = end.right;
            }
        }
        return true;
    }

}
