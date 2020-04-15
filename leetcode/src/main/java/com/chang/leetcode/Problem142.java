/**
 * 142. Linked List Cycle II
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents
 * the position (0-indexed) in the linked list where tail connects to. If pos is -1,
 * then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
package com.chang.leetcode;

import com.chang.common.ListNode;

public class Problem142 {

    /**
     * A bit explaination.
     * Provide the X is the length from head to the start point of circle and Y is the length of the circle.
     * We know slow moves t, while fast moves 2t. They meet at K where is the length from the start point of the circle.
     * Then we have :
     * t = X + nY + K
     * 2t = X + mY + K
     * , then we get
     * X+K  =  (m-2n)Y
     * which means when they meet at K, the length from K to start point of the circle is just the X.
     * At this moment, we use a head pointer to move by the same step (=1), and they must meet at the start point of the circle which we want.
     * (在K位置，再走X步就是起点)
     */
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        do {
            slow = slow.next;
            quick = quick.next.next;
        } while (null != quick && null != quick.next && quick != slow);
        if (null == quick || null == quick.next) {
            return null;
        }

        while (head != quick) {
            quick = quick.next;
            head = head.next;
        }
        return head;
    }


}
