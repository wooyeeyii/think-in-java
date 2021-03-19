/*
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Given a binary tree
 *
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
package com.chang.leetcode;

import com.chang.common.TreeLinkNode;

public class Problem117 {
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode curLayer = new TreeLinkNode(-1);
        TreeLinkNode nextLayer = new TreeLinkNode(-1);
        curLayer.next = root;

        while (null != curLayer.next) {
            TreeLinkNode node = curLayer.next;
            nextLayer.next = null;
            TreeLinkNode nextNode = null;
            while (node != null) {
                if (null != node.left && null != node.right) {
                    node.left.next = node.right;
                    if (null == nextLayer.next) {
                        nextLayer.next = node.left;
                    } else {
                        nextNode.next = node.left;
                    }
                    nextNode = node.right;
                } else if (null != node.left && null == node.right) {
                    if (null == nextLayer.next) {
                        nextLayer.next = node.left;
                    } else {
                        nextNode.next = node.left;
                    }
                    nextNode = node.left;
                } else if (null == node.left && null != node.right) {
                    if (null == nextLayer.next) {
                        nextLayer.next = node.right;
                    } else {
                        nextNode.next = node.right;
                    }
                    nextNode = node.right;
                }
                node = node.next;
            }
            curLayer.next = nextLayer.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Problem117 problem = new Problem117();
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n7 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;
        TreeLinkNode node = problem.connect(n1);
        System.out.println(node);
    }

}
