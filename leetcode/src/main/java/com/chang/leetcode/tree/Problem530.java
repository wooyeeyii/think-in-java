/*
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 * 1
 * \
 * 3
 * /
 * 2
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note: There are at least two nodes in this BST.
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem530 {

    List<Integer> list = new ArrayList<>();

    public int getMinimumDifferenceSlow(TreeNode root) {
        inOrderTraversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    private void inOrderTraversal(TreeNode root) {
        if (null != root.left) {
            inOrderTraversal(root.left);
        }
        list.add(root.val);
        if (null != root.right) {
            inOrderTraversal(root.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        Integer pre = null;
        int min = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                if (null != pre && node.val - pre < min) {
                    min = node.val - pre;
                }
                pre = node.val;
                p = node.right;
            }
        }
        return min;
    }

}
