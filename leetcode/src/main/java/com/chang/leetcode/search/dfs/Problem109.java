/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 *
 */
package com.chang.leetcode.search.dfs;

import com.chang.common.ListNode;
import com.chang.common.TreeNode;

public class Problem109 {

    public TreeNode sortedListToBST(ListNode node) {
        return sortedListToBST(node, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = sortedListToBST(head, slow);
        thead.right = sortedListToBST(slow.next, tail);
        return thead;
    }

    public static void main(String[] args) {
        Problem109 problem = new Problem109();
        ListNode listNode = new ListNode(0);
        TreeNode node = problem.sortedListToBST(listNode);
    }

}
