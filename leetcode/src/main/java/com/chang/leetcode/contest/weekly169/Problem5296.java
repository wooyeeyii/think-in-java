package com.chang.leetcode.contest.weekly169;

import com.chang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem5296 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        getValuesInOrder(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        getValuesInOrder(root2, list2);

        return mergeTwoList(list1, list2);
    }

    private void getValuesInOrder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }

        getValuesInOrder(node.left, list);
        list.add(node.val);
        getValuesInOrder(node.right, list);
    }

    private List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int m = list1.size(), n = list2.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        while (i < m) {
            merged.add(list1.get(i));
            i++;
        }
        while (j < n) {
            merged.add(list2.get(j));
            j++;
        }
        return merged;
    }

    public static void main(String[] args) {
        Problem5296 problem = new Problem5296();
    }

}
