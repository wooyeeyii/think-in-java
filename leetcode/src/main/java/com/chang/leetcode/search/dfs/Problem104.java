/*
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem104 {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // non recursive
    public int maxDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (null != n.left) next.offer(n.left);
                if (null != n.right) next.offer(n.right);
            }
            queue = next;
        }
        return depth;
    }

}
