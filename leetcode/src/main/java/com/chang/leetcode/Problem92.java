/*
 * 92. Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode start = preHead;
        ListNode node = head;
        int i = 1;
        while (i < m) {
            start = node;
            node = node.next;
            i++;
        }
        ListNode lastNode = node;
        i++;
        while (i <= n && lastNode.next != null) {
            node = lastNode.next;
            lastNode.next = node.next;
            node.next = start.next;
            start.next = node;
            i++;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Problem92 problem = new Problem92();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        //Input: 1->2->3->4->5->NULL, m = 2, n = 4
        //Output: 1->4->3->2->5->NULL
        ListNode res = problem.reverseBetween(n1, 1, 5);
        while (null != res) {
            System.out.println(res.val + ", ");
            res = res.next;
        }
        System.out.println("#################");
    }

}
