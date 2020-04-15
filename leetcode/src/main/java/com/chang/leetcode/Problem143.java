/**
 * 143. Reorder List
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem143 {

    public void reorderList(ListNode head) {
        if (null == head) {
            return;
        }
        int count = 0;
        ListNode node = head;
        ListNode beforehalf = new ListNode(-1);
        beforehalf.next = head;
        while (null != node) {
            count++;
            node = node.next;
        }
        int i = 0;
        node = beforehalf;
        while (i < (count % 2 == 0 ? count / 2 : count / 2 + 1)) {
            node = node.next;
            i++;
        }
        beforehalf.next = node.next;
        node.next = null;

        // 后半段倒序
        node = beforehalf.next;
        if (null == node) {
            return;
        }
        while (null != node.next) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = beforehalf.next;
            beforehalf.next = next;
        }
        //合并两个半段，最后个节点.next = null
        node = head;
        ListNode node2 = beforehalf.next;
        while (null != node && null != node2) {
            ListNode newStart = node2.next;
            node2.next = node.next;
            node.next = node2;
            node = node2.next;
            node2 = newStart;
        }
    }

    public static void main(String[] args) {
        Problem143 problem = new Problem143();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        problem.reorderList(null);
        while (null != n1) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
        System.out.println("######################3");

        ListNode m1 = new ListNode(1);
//        ListNode m2 = new ListNode(2);
//        ListNode m3 = new ListNode(3);
//        ListNode m4 = new ListNode(4);
//        m1.next = m2;
//        m2.next = m3;
//        m3.next = m4;
        problem.reorderList(m1);
        while (null != m1) {
            System.out.println(m1.val);
            m1 = m1.next;
        }
    }
}
