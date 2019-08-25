package com.chang.leetcode.contest.weekly151;

import com.chang.common.ListNode;

public class Problem1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode node = head;
        ListNode newHead = null;
        ListNode nowNode = newHead;
        while(null != node) {
            ListNode next = removeZeroSub(node);
            if(null == newHead) {
                newHead = next;
                nowNode = next;
            } else {
                nowNode.next = next;
                nowNode = next;
            }

            node = null == next? null : next.next;
        }
        return newHead;
    }

    private ListNode removeZeroSub(ListNode head) {
        ListNode node = head;
        int sum = 0;
        while(node != null) {
            sum += node.val;
            if(0 == sum) {
                head = node.next;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem1171 problem = new Problem1171();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(-3);
        ListNode n5 = new ListNode(-2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res1 = problem.removeZeroSumSublists(n1);
        print(res1);
    }

    private static void print(ListNode n) {
        System.out.println("############################");
        System.out.print("[");
        while(null != n) {
            System.out.print(n.val + ", ");
            n = n.next;
        }
        System.out.println("]");

    }

}
