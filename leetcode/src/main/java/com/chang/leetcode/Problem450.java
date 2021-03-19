/*
 * 450. Delete Node in a BST
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
package com.chang.leetcode;

import com.chang.common.TreeNode;

public class Problem450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode node = root;
        while (node != null) {
            if (key == node.val) {
                break;
            } else if (key < node.val) {
                parent = node;
                node = node.left;
            } else {
                parent = node;
                node = node.right;
            }
        }
        if (null == node) {
            return root;
        }

        TreeNode head = null;
        if (null == parent) {
            head = reShape(root, null, root);
            return head;
        } else {
            head = reShape(root, parent, node);
        }
        return head;
    }

    private TreeNode reShape(TreeNode root, TreeNode parent, TreeNode node) {
        if (null == node.left) {
            if (null == parent) {
                return node.right;
            } else {
                if (node == parent.left) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        } else if (null == node.right) {
            if (null == parent) {
                return node.left;
            } else {
                if (node == parent.left) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        } else {
            if (null == parent) {
                root = node.left;
                insert(node.left, node.right);
            } else {
                if (node == parent.left) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
                insert(node.left, node.right);
            }
        }
        return root;
    }

    private void insert(TreeNode root, TreeNode node) {
        if (node.val > root.val) {
            if (null == root.right) {
                root.right = node;
                return;
            } else {
                insert(root.right, node);
            }
        } else {
            if (null == root.left) {
                root.left = node;
                return;
            } else {
                insert(root.left, node);
            }
        }
    }


}
