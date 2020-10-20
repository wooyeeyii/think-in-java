/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.TreeNode;

public class Problem106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postEnd < postStart) {
            return null;
        }

        if (0 == postStart - postEnd) {
            return new TreeNode(postorder[postEnd]);
        }

        TreeNode r = new TreeNode(postorder[postEnd]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (r.val == inorder[i]) {
                idx = i;
                break;
            }
        }
        int count = idx - inStart;

        r.left = buildTree(inorder, inStart, idx - 1, postorder, postStart, postStart + count - 1);
        r.right = buildTree(inorder, idx + 1, inEnd, postorder, postStart + count, postEnd - 1);
        return r;
    }

    public static void main(String[] args) {
        Problem106 problem = new Problem106();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = problem.buildTree(inorder, postorder);
        System.out.println(root);
    }

}
