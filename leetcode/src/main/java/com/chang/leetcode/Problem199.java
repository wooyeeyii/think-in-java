/*
 * 199. Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
package com.chang.leetcode;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (null != node) {
            queue.add(node);
            list.add(node.val);
        }
        while (queue.size() > 0) {
            Queue<TreeNode> nextQ = new LinkedList<>();
            TreeNode right = null;
            while (queue.size() > 0) {
                node = queue.poll();
                if (node.left != null) {
                    nextQ.add(node.left);
                    right = node.left;
                }
                if (null != node.right) {
                    nextQ.add(node.right);
                    right = node.right;
                }
            }
            if (null != right) {
                list.add(right.val);
            }
            queue = nextQ;
        }
        return list;
    }


}
