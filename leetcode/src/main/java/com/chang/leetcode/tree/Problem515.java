/*
 * 515. Find Largest Value in Each Tree Row
 *
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 *
 * Output: [1, 3, 9]
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (null != root) {
            largestValues(root, 0, result);
        }
        return result;
    }

    private void largestValues(TreeNode node, int depth, List<Integer> result) {
        if (depth >= result.size()) {
            result.add(node.val);
        } else if (node.val > result.get(depth)) {
            result.set(depth, node.val);
        }

        if (null != node.left) {
            largestValues(node.left, depth + 1, result);
        }
        if (null != node.right) {
            largestValues(node.right, depth + 1, result);
        }
    }


    public static void main(String[] args) {
        Problem515 problem = new Problem515();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n3;
        n1.right = n2;
        n2.right = n4;
        n3.right = n5;
        System.out.println(problem.largestValues(n1));
    }
}
