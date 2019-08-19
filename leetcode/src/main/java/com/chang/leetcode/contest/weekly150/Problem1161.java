package com.chang.leetcode.contest.weekly150;

import com.chang.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1161 {

    public int maxLevelSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int max = root.val;
        int pos = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 2;
        while (queue.size() > 0) {
            Queue<TreeNode> next = new LinkedList<>();
            int sum = 0;
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    sum += node.left.val;
                    next.add(node.left);
                }
                if (null != node.right) {
                    sum += node.right.val;
                    next.add(node.right);
                }
            }

            if (sum > max) {
                max = sum;
                pos = level;
            }
            queue = next;
            level++;
        }

        return pos;
    }

}
