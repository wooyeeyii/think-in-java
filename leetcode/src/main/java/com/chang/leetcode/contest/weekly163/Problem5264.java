package com.chang.leetcode.contest.weekly163;

import com.chang.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Problem5264 {

    private Set<Integer> set = new HashSet<>();

    public Problem5264(TreeNode root) {
        set.add(0);
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                int lv = 2 * node.val + 1;
                node.left.val = lv;
                set.add(lv);
                queue.add(node.left);
            }
            if(node.right != null) {
                int rv = 2 * node.val + 2;
                node.right.val = rv;
                set.add(rv);
                queue.add(node.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-1);
        TreeNode n4 = new TreeNode(-1);
        TreeNode n5 = new TreeNode(-1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        Problem5264 problem = new Problem5264(n1);
        System.out.println(problem.find(1));
        System.out.println(problem.find(2));
        System.out.println(problem.find(3));
        System.out.println(!problem.find(5));


    }


}
