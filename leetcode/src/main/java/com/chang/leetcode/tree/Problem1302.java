/*
 * 1302. Deepest Leaves Sum
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Problem1302 {

    /* -------------------
     * use height of tree;
     * ------------------- */
    private int height = 0;
    private int sum = 0;

    public int deepestLeavesSumOne(TreeNode root) {
        height = height(root);
        deepestLeavesSum(root, 1);
        return sum;
    }

    private int height(TreeNode node) {
        if (null == node) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private void deepestLeavesSum(TreeNode node, int n) {
        if (null == node) {
            return;
        }

        if (n == height) {
            sum += node.val;
            return;
        }

        deepestLeavesSum(node.left, n + 1);
        deepestLeavesSum(node.right, n + 1);
    }

    // no need for two queue;
    public int deepestLeavesSumRedundant(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            Queue<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode no = queue.poll();
                sum += no.val;
                Optional.ofNullable(no.left).ifPresent(p -> next.offer(p));
                Optional.ofNullable(no.right).ifPresent(p -> next.offer(p));
            }

            queue = next;
        }
        return sum;
    }

    // improvement
    public int deepestLeavesSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode no = queue.poll();
                sum += no.val;
                Optional.ofNullable(no.left).ifPresent(p -> queue.offer(p));
                Optional.ofNullable(no.right).ifPresent(p -> queue.offer(p));
            }
        }
        return sum;
    }

}

