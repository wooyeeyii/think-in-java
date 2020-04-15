package com.chang.leetcode;

import com.chang.common.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

public class Problem116 {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        list.add(root);
        root.next = null;
        TreeLinkNode newStart = null;
        for (TreeLinkNode node : list) {
            node.next = null;
            List<TreeLinkNode> nextLine = new ArrayList<>();
            if (newStart == null) {
                newStart = node;
            } else {
                newStart.next = node;
                newStart = node;
            }
            if (node.left != null) {
                nextLine.add(node.left);
            }
            if (node.right != null) {
                nextLine.add(node.right);
            }
            list = nextLine;
            newStart = null;
        }
    }
}


