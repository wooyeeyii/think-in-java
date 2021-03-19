/*
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.TreeNode;

public class Problem108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end < start || end < 0 || start >= nums.length) {
            return null;
        }

        if (end == start) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, start, middle - 1);
        node.right = sortedArrayToBST(nums, middle + 1, end);

        return node;
    }

    public static void main(String[] args) {
        Problem108 problem = new Problem108();
        TreeNode node = problem.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}
