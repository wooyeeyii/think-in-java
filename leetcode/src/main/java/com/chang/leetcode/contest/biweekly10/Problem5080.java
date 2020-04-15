package com.chang.leetcode.contest.biweekly10;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem5080 {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> nodes1 = new ArrayList<>();
        inorderTraversal(root1, nodes1);
        List<Integer> nodes2 = new ArrayList<>();
        inorderTraversal(root2, nodes2);

        for (int i = 0; i < nodes1.size(); i++) {
            for (int j = 0; j < nodes2.size(); j++) {
                if (target == nodes1.get(i) + nodes2.get(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> records) {
        if (null == node) {
            return;
        }

        inorderTraversal(node.left, records);
        records.add(node.val);
        inorderTraversal(node.right, records);
    }

    public static void main(String[] args) {
        Problem5080 problem = new Problem5080();
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;

        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(0);
        TreeNode m3 = new TreeNode(3);
        m1.left = m2;
        m1.right = m3;
        System.out.println(problem.twoSumBSTs(n1, m1, 5));
    }

}
