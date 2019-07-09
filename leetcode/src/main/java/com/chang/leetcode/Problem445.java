/**
 * 445. Add Two Numbers II
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

import java.util.Stack;

public class Problem445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode end = new ListNode(0);
        while(!s1.empty() || !s2.empty() || sum > 0) {
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            end.val = sum % 10;
            ListNode head = new ListNode(0);
            head.next = end;
            end = head;
            sum /= 10;
        }
        return end.val == 0? end.next : end;
    }

    public static void main(String[] args) {
        Problem445 problem = new Problem445();
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(4);
        n5.next = n6;
        n6.next = n7;

        ListNode n = problem.addTwoNumbers(n5, n1);
        while(null != n) {
            System.out.print(n.val + ", ");
            n = n.next;
        }
        System.out.println();
        System.out.println("############");


    }
}
