package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headAfterk = head;

        //创建一个空的头结点
        ListNode headNull = new ListNode(-1);
        headNull.next = head;


        ListNode begin = null;
        ListNode tail = null;
        while (null != headAfterk) {
            begin = headAfterk;
            for (int i = 0; i < k; i++) {
                if (null != headAfterk) {
                    headAfterk = headAfterk.next;
                } else {
                    return headNull.next;
                }
            }

            //有k个元素了，交换顺序
            if (null == tail) {
                ListNode tmp = begin;
                while (tmp != headAfterk && tmp != null) {
                    ListNode tmpNext = tmp.next;
                    tmp.next = headNull.next;
                    headNull.next = tmp;
                    tmp = tmpNext;
                }
            } else {
                ListNode tmp = begin;
                while (tmp != headAfterk && tmp != null) {
                    ListNode tmpNext = tmp.next;
                    tmp.next = tail.next;
                    tail.next = tmp;
                    tmp = tmpNext;
                }
            }

            tail = begin;
            tail.next = headAfterk;
        }
        return headNull.next;
    }


    public static void main(String[] args) {
        Problem25 problem = new Problem25();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 1; i < 2; i++) {
            ListNode tmp = new ListNode(i);
            tmp.next = null;

            if (null != tail) {
                tail.next = tmp;
                tail = tmp;
            }
            if (null == head) {
                head = tmp;
                tail = tmp;
            }
        }
        problem.printList(head);
        ListNode res = problem.reverseKGroup(head, 2);
        problem.printList(res);
    }

    public void printList(ListNode head) {
        while (null != head) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("++++++++++++++++++++++++++");
    }
}



