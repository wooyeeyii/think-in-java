/*
 * 剑指offer 25: two sorted linked list merge into one sorted list
 *
 * 常俊杰
 * 420381199106240031
 * 2021/03/15
 */
package com.chang.once;

public class Problem25 {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode end = head;
        while (null != a && null != b) {
            if (a.val <= b.val) {
                end.next = a;
                end = a;
                a = a.next;
            } else {
                end.next = b;
                end = b;
                b = b.next;
            }
        }

        if (null != a) {
            end.next = a;
        } else if (null != b) {
            end.next = b;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Problem25 problem = new Problem25();
        ListNode a = problem.new ListNode(1);
        ListNode b = problem.new ListNode(2);
        ListNode a1 = problem.new ListNode(3);
        ListNode b1 = problem.new ListNode(4);
        ListNode a2 = problem.new ListNode(5);
        ListNode b2 = problem.new ListNode(6);
        ListNode a3 = problem.new ListNode(7);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        b.next = b1;
        b1.next = b2;
        ListNode node = problem.merge(null, b);
        while (null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
