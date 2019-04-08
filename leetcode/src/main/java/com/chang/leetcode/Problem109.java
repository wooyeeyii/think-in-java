/**
 * 109 Convert Sorted List to Binary Search Tree
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5],
 * which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
package com.chang.leetcode;

import com.chang.common.ListNode;
import com.chang.common.TreeNode;

public class Problem109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode end = head;
        while(end.next != null) {
            end = end.next;
        }
        return sortedListToBSTDiv(head, end);
    }

    public TreeNode sortedListToBSTDiv(ListNode head, ListNode end) {
        if(head == null) {
            return null;
        }
        if(head == end) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode quick = head;
        ListNode preSlow = null;
        while(quick != null && quick.next != null){
            preSlow = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        preSlow.next = null;
        root.left = sortedListToBSTDiv(head, preSlow);
        root.right = sortedListToBSTDiv(slow.next, end);
        return root;
    }

    public static void main(String[] args) {
        Problem109 problem = new Problem109();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        TreeNode res = problem.sortedListToBST(n1);
        System.out.println(res);

    }
}
