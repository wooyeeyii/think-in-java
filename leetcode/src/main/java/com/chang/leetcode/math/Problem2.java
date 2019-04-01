/**
 * Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
package com.chang.leetcode.math;

import com.chang.common.ListNode;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode tmp = null;
        int highBit = 0;
        while (null != l1 && null != l2) {
            int l1Cur = l1.val;
            int l2Cur = l2.val;
            ListNode node = new ListNode((l1Cur + l2Cur + highBit) % 10);
            node.next = null;
            highBit = (l1Cur + l2Cur + highBit) / 10;
            if (null == start) {
                start = node;
                tmp = node;
            } else {
                tmp.next = node;
            }
            tmp = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode leftNode = null;
        if(null == l1 && null != l2) {
            leftNode = l2;
        } else if(null != l1 && null == l2) {
            leftNode = l1;
        }
        while(null != leftNode) {
            ListNode node = new ListNode((leftNode.val + highBit) % 10);
            node.next = null;
            highBit = (leftNode.val + highBit) / 10;
            tmp.next = node;
            tmp = node;
            leftNode = leftNode.next;
        }
        if(0 != highBit) {
            ListNode node = new ListNode(highBit);
            node.next = null;
            tmp.next = node;
        }

        return start;
    }

    public static void main(String[] args) {
        Problem2 problem = new Problem2();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode a = new ListNode(8);
        l2.next = a;
        problem.addTwoNumbers(l1, l2);
    }


}
