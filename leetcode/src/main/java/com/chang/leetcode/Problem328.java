/*
 * 328. Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem328 {

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode oddRoot = head;
        ListNode odd = head;
        ListNode oddLast = head;
        ListNode evenRoot = head.next;
        ListNode even = odd.next;
        while (null != even) {
            odd.next = even.next;
            if (null != odd.next) {
                oddLast = odd.next;
            }
            even.next = (null == even.next ? null : even.next.next);
            odd = odd.next;
            even = even.next;
        }

        oddLast.next = evenRoot;
        return oddRoot;
    }

    public static void main(String[] args) {
        Problem328 problem = new Problem328();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
//        n7.next = n8;
        ListNode res = problem.oddEvenList(n1);
        printListNode(res);
    }

    private static void printListNode(ListNode root) {
        while (null != root) {
            System.out.print(root.val);
            System.out.print(" ");
            root = root.next;
        }
        System.out.println();
        System.out.println("########################");
    }
}
