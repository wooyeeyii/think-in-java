/**
 * 100. Same Tree
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
package com.chang.leetcode.search.depth.first;

import com.chang.common.TreeNode;

public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) {
            return p == q;
        } else {
            return p.val == q.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
        }
    }

}
