/*
 * 129. Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 * 
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
package com.chang.leetcode;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem129 {

    /*
     * 自下而上
     */
    public int sumNumbersBottomUp(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return sumNumberLayer(root, new ArrayList<Integer>());
    }

    public int sumNumberLayer(TreeNode node, List<Integer> leafLayers) {
        if (null == node.left && null == node.right) {
            leafLayers.add(1);
            return node.val;
        }

        int left = 0;
        int right = 0;
        List<Integer> leftLeaves = new ArrayList<Integer>();
        List<Integer> rightLeaves = new ArrayList<Integer>();
        if (null != node.left) {
            left = sumNumberLayer(node.left, leftLeaves);
        }
        if (null != node.right) {
            right = sumNumberLayer(node.right, rightLeaves);
        }
        int sum = left + right;
        leafLayers.addAll(leftLeaves);
        leafLayers.addAll(rightLeaves);
        for (int i = 0; i < leafLayers.size(); i++) {
            sum += node.val * Math.pow(10, leafLayers.get(i));
            leafLayers.set(i, leafLayers.get(i) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem129 problem = new Problem129();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(1026 == problem.sumNumbers(t1));

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(25 == problem.sumNumbers(n1));

        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(5);
        TreeNode m3 = new TreeNode(1);
        TreeNode m4 = new TreeNode(6);
        m1.left = m2;
        m1.right = m3;
        m3.right = m4;
        System.out.println(131 == problem.sumNumbers(m1));
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (null == root) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> sumQ = new LinkedList<Integer>();
        queue.add(root);
        sumQ.add(root.val);
        sum = root.val;
        while (queue.size() > 0) {
            Queue<TreeNode> nextQ = new LinkedList<TreeNode>();
            Queue<Integer> nextSumQ = new LinkedList<Integer>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                Integer rootVal = sumQ.poll();
                if (null != node.left || null != node.right) {
                    sum -= rootVal;
                }
                if (null != node.left) {
                    sum += rootVal * 10 + node.left.val;
                    nextQ.add(node.left);
                    nextSumQ.add(rootVal * 10 + node.left.val);
                }
                if (null != node.right) {
                    sum += rootVal * 10 + node.right.val;
                    nextQ.add(node.right);
                    nextSumQ.add(rootVal * 10 + node.right.val);
                }
            }
            queue = nextQ;
            sumQ = nextSumQ;
        }
        return sum;
    }
}
