/**
 * 543. Diameter of Binary Tree
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

public class Problem543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        int height = heightOfBinaryTree(root);

        return max;
    }

    private int heightOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        max = Math.max(leftHeight + rightHeight, max);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Problem543 problem = new Problem543();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(3 == problem.diameterOfBinaryTree(n1));
    }


}
