/**
 * 230. Kth Smallest Element in a BST
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need
 * to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
package com.chang.leetcode;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem230 {

    private int k;
    private Integer res = null;

    public int kthSmallest(TreeNode root, int k) {
        if (null == root || k <= 0) {
            return 0;
        }
        this.k = k;
        preOrderTra(root);
        return res == null ? 0 : res;
    }

    private void preOrderTra(TreeNode node) {
        if (null != node.left && k > 0) {
            preOrderTra(node.left);
        }
        //根节点
        k = k - 1;
        if (0 == k) {
            res = node.val;
            return;
        }

        if (null != node.right && k > 0) {
            preOrderTra(node.right);
        }
    }

    public static void main(String[] args) {
        Problem230 problem = new Problem230();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        System.out.println(4 == problem.kthSmallest(n1, 4));
        System.out.println("##");
    }


}
