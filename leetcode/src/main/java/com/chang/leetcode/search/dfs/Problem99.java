/**
 * 99. Recover Binary Search Tree
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * <p>
 * Example 2:
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * Output: [2,1,4,null,null,3]
 * 2
 * / \
 * 1   4
 * /
 * 3
 * <p>
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.TreeNode;

public class Problem99 {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right != null && temp.right != root)
                    temp = temp.right;
                // the threading already exists
                if (temp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;

                    temp.right = null;
                    root = root.right;
                } else {
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            } else {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                        second = root;
                    } else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }

    public static void main(String[] args) {
        Problem99 problem = new Problem99();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        n3.right = n2;
        problem.recoverTree(n1);
    }

}
