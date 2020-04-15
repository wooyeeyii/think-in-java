/**
 * 513. Find Bottom Left Tree Value
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 1   3
 * Output:
 * 1
 * <p>
 * Example 2:
 * Input:
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode left = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            TreeNode leftNext = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    if (null == leftNext) {
                        leftNext = node.left;
                    }
                    next.add(node.left);
                }
                if (null != node.right) {
                    if (null == leftNext) {
                        leftNext = node.right;
                    }
                    next.add(node.right);
                }
            }
            queue = next;
            if (null != leftNext) {
                left = leftNext;
            }
        }
        return left.val;
    }

    public static void main(String[] args) {
        Problem513 problem = new Problem513();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n4.right = n5;
        System.out.println(5 == problem.findBottomLeftValue(n1));
    }

    public int findBottomLeftValueExample(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0, 0});
    }

    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) findBottomLeftValue(root.left, depth + 1, res);
        if (root.right != null) findBottomLeftValue(root.right, depth + 1, res);
        return res[0];
    }

}
