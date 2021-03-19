/*
 * 1530. Number of Good Leaf Nodes Pairs
 *
 * Given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good
 * if the length of the shortest path between them is less than or equal to distance.
 *
 * Return the number of good leaf node pairs in the tree.
 *
 * Example 1:
 * Input: root = [1,2,3,null,4], distance = 3
 * Output: 1
 * Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
 *
 * Example 2:
 * Input: root = [1,2,3,4,5,6,7], distance = 3
 * Output: 2
 * Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2.
 * The pair [4,6] is not good because the length of ther shortest path between them is 4.
 *
 * Example 3:
 * Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * Output: 1
 * Explanation: The only good pair is [2,5].
 *
 * Example 4:
 * Input: root = [100], distance = 1
 * Output: 0
 *
 * Example 5:
 * Input: root = [1,1,1], distance = 2
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 2^10].
 * Each node's value is between [1, 100].
 * 1 <= distance <= 10
 */
package com.chang.leetcode.tree;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1530 {

    public int countPairs(TreeNode root, int distance) {
        return countDepth(root, distance, new ArrayList<>());
    }

    public int countDepth(TreeNode node, int distance, List<Integer> list) {
        if (null == node) {
            return 0;
        }

        if (null == node.left && null == node.right) {
            list.add(0);
            return 0;
        }

        List<Integer> lefts = new ArrayList<>();
        int l = countDepth(node.left, distance, lefts);
        lefts.forEach(n -> list.add(n + 1));
        List<Integer> rights = new ArrayList<>();
        int r = countDepth(node.right, distance, rights);
        rights.forEach(n -> list.add(n + 1));

        int m = 0;
        for (int i : lefts) {
            for (int j : rights) {
                if (i + j + 2 <= distance) {
                    m++;
                }
            }
        }
        return l + r + m;
    }

    public static void main(String[] args) {
        Problem1530 problem = new Problem1530();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        System.out.println(problem.countPairs(t1, 3));

        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(4);
        TreeNode p7 = new TreeNode(4);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        System.out.println(problem.countPairs(p1, 3));
    }

    private int res;

    public int countPairsExample(TreeNode root, int distance) {
        res = 0;
        helper(root, distance);
        return res;
    }

    private int[] helper(TreeNode node, int distance) {
        if (node == null) return new int[11];

        int[] left = helper(node.left, distance);
        int[] right = helper(node.right, distance);

        int[] A = new int[11];

        // node is leaf node, no child, just return
        if (node.left == null && node.right == null) {
            A[1] = 1;
            return A;
        }

        // find all nodes satisfying distance
        for (int i = 0; i <= 10; ++i) {
            for (int j = 0; j <= 10; ++j) {
                if (i + j <= distance) {
                    res += (left[i] * right[j]);
                }
            }
        }

        // increment all by 1, ignore the node distance larger than 10
        for (int i = 0; i <= 9; ++i) {
            A[i + 1] += left[i];
            A[i + 1] += right[i];
        }

        return A;
    }


}
