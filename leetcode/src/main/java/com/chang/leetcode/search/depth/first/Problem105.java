/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
package com.chang.leetcode.search.depth.first;

import com.chang.common.TreeNode;

public class Problem105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) {
            return null;
        }

        if(0 == preStart - preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        TreeNode r = new TreeNode(preorder[preStart]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (r.val == inorder[i]) {
                idx = i;
                break;
            }
        }
        int count = idx - inStart;

        r.left = buildTree(preorder, preStart + 1, preStart + count, inorder, idx - count, idx - 1);
        r.right = buildTree(preorder, preStart + count + 1, preEnd, inorder, idx + 1, inEnd);
        return r;
    }

    public static void main(String[] args) {
        Problem105 problem = new Problem105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = problem.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
