/**
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

import java.util.List;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode node = head;
        ListNode pre = preHead;
        boolean duplicate = false;
        while (null != node) {
            while (node.next != null && node.val == node.next.val) {
                duplicate = true;
                node = node.next;
            }
            if (duplicate) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
            duplicate = false;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Problem82 problem = new Problem82();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode res = problem.deleteDuplicates(n1);
        while (null != res) {
            System.out.println(res.val + ", ");
            res = res.next;
        }
    }


}
