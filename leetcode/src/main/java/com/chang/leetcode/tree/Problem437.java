/**
 * Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

public class Problem437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }


    int oriSum = 0;
    /**
     * 错误的算法，递归有重复
     * 仔细思考，例如A1-B右2-C右3-D右4的树， sum = 4，
     * 则计算A节点的时候，则D单节点满足要求，以B为根节点递归时，D单节点又算了一次，算重复了
     */
    public int pathSum_Wrong(TreeNode root, int sum) {
        oriSum = sum;
        return pathSumRec(root, sum);
    }
    private int pathSumRec(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        if(root.val == sum) {
            int a = pathSumRec(root.left, 0);
            int b = pathSumRec(root.left, oriSum);
            int c = pathSumRec(root.right, 0);
            int d = pathSumRec(root.right, oriSum);
            System.out.printf("%d, %d, %d, %d, %d", root.val, a, b, c, d);
            System.out.println();
            return 1 + a + b + c + d;
        }
        return pathSumRec(root.left, sum - root.val) + pathSumRec(root.left, oriSum) +
                pathSumRec(root.right, sum - root.val) + pathSumRec(root.right, oriSum);
    }

    public static void main(String[] args) {
        Problem437 problem = new Problem437();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.right = b;
        b.right = c;
        c.right = d;
        System.out.println(problem.pathSum(a, 3));
    }

}
