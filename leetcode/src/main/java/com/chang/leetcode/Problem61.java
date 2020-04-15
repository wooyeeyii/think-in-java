/**
 * 61. Rotate List
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * <p>
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || 0 == k) {
            return head;
        }
        int size = 1;
        ListNode end = head;
        while (null != end.next) {
            size++;
            end = end.next;
        }
        end.next = head;

        k = k % size;
        k = size - k;
        while (k > 0) {
            end = end.next;
            k--;
        }
        head = end.next;
        end.next = null;
        return head;
    }

    public static void main(String[] args) {
        Problem61 problem = new Problem61();
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        ListNode res = problem.rotateRight(n1, 2);

        ListNode m1 = new ListNode(0);
        ListNode m2 = new ListNode(1);
        ListNode m3 = new ListNode(2);
        m1.next = m2;
        m2.next = m3;
        ListNode res = problem.rotateRight(m1, 4);
        while (null != res) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
