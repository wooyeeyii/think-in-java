/*
 * 148. Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem148 {

    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode toHead = new ListNode(-1);
        toHead.next = head;
        sortList(toHead, null);
        return toHead.next;
    }

    private void sortList(ListNode start, ListNode end) {
        ListNode flag = start.next;
        ListNode node = flag;
        while (null != node.next && node.next != end) {
            ListNode after = node.next;
            if (after.val < flag.val) {
                node.next = after.next;
                after.next = start.next;
                start.next = after;
            } else {
                node = node.next;
            }
        }
        if (start.next != flag && start != flag) {
            sortList(start, flag);
        }
        if (flag.next != end && flag != end) {
            sortList(flag, end);
        }
    }

    public static void main(String[] args) {
        Problem148 problem = new Problem148();
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = problem.sortList(n1);
        while (null != res) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println("##########################");

    }
}
