/**
 * 86. Partition List
 * <p>
 * Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prePos = preHead;
        ListNode nodePos = head;
        ListNode pre = preHead;
        ListNode node = head;
        while (null != node && x > node.val) {
            if (node.val > nodePos.val) {
                prePos = pre;
                nodePos = node;
            }
            pre = node;
            node = node.next;
        }
        if (null != node && node.val >= x) {
            if (node.val > nodePos.val) {
                prePos = pre;
                nodePos = node;
            }
            pre = node;
            node = node.next;
        }
        while (null != node) {
            if (node.val < x) {
                pre.next = node.next;
                node.next = prePos.next;
                prePos.next = node;
                prePos = node;
                node = pre.next;
            } else {
                pre = node;
                node = node.next;
            }

        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Problem86 problem = new Problem86();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode res = problem.partition(n1, 3);
        //1->2->2->4->3->5
        while (null != res) {
            System.out.println(res.val + ", ");
            res = res.next;
        }
        System.out.println("#################");


        // input [3,1] 2
        //output [1,3]
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(1);
        m1.next = m2;
        ListNode res2 = problem.partition(m1, 2);
        //1->2->2->4->3->5
        while (null != res2) {
            System.out.println(res2.val + ", ");
            res2 = res2.next;
        }
        System.out.println("#################");
    }
}
